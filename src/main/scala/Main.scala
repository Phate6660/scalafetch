import java.nio.file.{Paths, Files}
import scala.io.Source
import scala.language.postfixOps
import sys.process._

object Functions {
  def ReadFile(file: String, message: String) : String = {
    if (Files.exists(Paths.get(file))) {
      val contents = Source.fromFile(file).getLines.mkString
      return message + contents
    } else {
      return "N/A (could not read " + file + ")"
    }
  }
  def ReadAndSplit(file: String, line: Int, message: String) : String = {
    val distContents = Source.fromFile(file).getLines.take(line).next().split("=") 
    return message + distContents(1)
  }
  def Distro() : String = {
    if (Files.exists(Paths.get("/bedrock/etc/os-release"))) {
      return ReadAndSplit("/bedrock/etc/os-release", 1, "Distro:    ")
    } else if(Files.exists(Paths.get("/etc/os-release"))) {
      return ReadAndSplit("/etc/os-release", 1, "Distro:    ")
    } else if(Files.exists(Paths.get("/usr/lib/os-release"))) {
      return ReadAndSplit("/usr/lib/os-release", 1, "Distro:    ")
    } else {
      return "N/A (could not read any os-release files)"
    }
  }
  def GPU() : String = {
    val output = "lspci" #| "grep -I 'VGA\\|Display\\|3D'" !!
    val model = output.split(":")(2).trim
    if (model.startsWith("Advanced Micro Devices, Inc.")) {
      return "GPU:       " + model.split("\\.")(1).trim.replace("[", "").replace("]", "").replace("\n", "")
    } else {
      return "GPU:       " + model.replace("\n", "")
    }
  }
  def Music() : String = {
    val title = "mpc -f %title%" #| "head -n1" !!
    val album = "mpc -f %album%" #| "head -n1" !!
    val artist = "mpc -f %artist%" #| "head -n1" !!
    val string = "Music:     " + artist.trim + " - " + album.trim + " - " + title.trim
    return string
  }
  def Duration(rawUptime: Int) : (String, String, String) = {
    val days = if (rawUptime > 86400) {
      val days_pre = rawUptime / 60 / 60 / 24
      days_pre + "d "
    } else {
      ""
    }
    val hours = if (rawUptime > 3600) {
      val hours_pre = (rawUptime / 60 / 60) % 24
      hours_pre + "h "
    } else {
      ""
    }
    val minutes = if (rawUptime > 60) {
      val minutes_pre = (rawUptime / 60) % 60
      minutes_pre + "m"
    } else {
      ""
    }
    return (days, hours, minutes)
  }
  def Uptime() : String = {
    if (Files.exists(Paths.get("/proc/uptime"))) {
      val uptiContents = Source.fromFile("/proc/uptime").getLines.mkString
      val rawUptime = uptiContents.split("\\.")(0).toInt
      val (days, hours, minutes) = Duration(rawUptime)
      return "Uptime:    " + days + hours + minutes
    } else {
      return "N/A (could not read /proc/uptime)"
    }
  }
}

object Main extends App {
  var distro, editor, gpu, help, hostname, kernel, music, shell, uptime, user = ""
  args.sliding(2, 2).toList.collect {
    case Array("-d", argDist: String) => distro = argDist
    case Array("-e", argEdit: String) => editor = argEdit
    case Array("-g", argGPU:  String) => gpu = argGPU
    case Array("-H", argHelp: String) => help = argHelp
    case Array("-h", argHost: String) => hostname = argHost
    case Array("-k", argKern: String) => kernel = argKern
    case Array("-m", argMusi: String) => music = argMusi
    case Array("-s", argShel: String) => shell = argShel
    case Array("-U", argUser: String) => user = argUser
    case Array("-u", argUpti: String) => uptime = argUpti
  }
  if(help == "true") {
    println("""-d  display the distro
-e  display $EDITOR
-g  display gpu model
-H  display this help
-h  display hostname
-k  display the kernel
-m  display currently playing music in mpd
-s  display the shell
-U  display the user
-u  display uptime""")
    System.exit(0)
  }
  if(distro == "true") {
    println(Functions.Distro())
  }
  if(editor == "true") {
    println("Editor:    " + sys.env("EDITOR"))
  }
  if(gpu == "true") {
    println(Functions.GPU())
  }
  if(hostname == "true") {
    println(Functions.ReadFile("/etc/hostname", "Hostname:  "))
  }
  if(kernel == "true") {
    println(Functions.ReadFile("/proc/sys/kernel/osrelease", "Kernel:    "))
  }
  if(shell == "true") {
    println("Shell:     " + sys.env("SHELL"))
  }
  if(uptime == "true") {
    println(Functions.Uptime())
  }
  if(user == "true") {
    println("User:      " + sys.env("USER"))
  }
  if(music == "true") {
    println(Functions.Music())
  }
}
