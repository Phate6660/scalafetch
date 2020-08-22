import scala.io.Source

object Functions {
  def ReadFile(file: String, message: String) : String = {
    val contents = Source.fromFile(file).getLines.mkString
    return message + contents
  }
  def Distro() : String = {
    val distContents = Source.fromFile("/etc/os-release").getLines.take(1).next().split("=") 
    return "Distro:   " + distContents(1)
  }
  def Hostname() : String = {
    return ReadFile("/etc/hostname", "Hostname: ")
  }
  def Kernel() : String = {
    return ReadFile("/proc/sys/kernel/osrelease", "Kernel:   ")
  }
}

object Main extends App {
  var distro, help, hostname, kernel = ""
  args.sliding(2, 2).toList.collect {
    case Array("-d", argDist: String) => distro = argDist
    case Array("-H", argHelp: String) => help = argHelp
    case Array("-h", argHost: String) => hostname = argHost
    case Array("-k", argKern: String) => kernel = argKern
  }
  if(help == "true") {
    println("""-d  display the distro
-H  display this help
-h  display hostname
-k  display the kernel""")
    System.exit(0)
  }
  if(distro == "true") {
    println(Functions.Distro())
  }
  if(hostname == "true") {
    println(Functions.Hostname())
  }
  if(kernel == "true") {
    println(Functions.Kernel())
  }
}
