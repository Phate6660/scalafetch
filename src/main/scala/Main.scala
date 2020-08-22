import scala.io.Source

object Functions {
  def Distro() : String = {
    val distContents = Source.fromFile("/etc/os-release").getLines.take(1).next().split("=") 
    return "Distro:   " + distContents(1)
  }
  def Hostname() : String = {
    val hostContents = Source.fromFile("/etc/hostname").getLines.mkString
    return "Hostname: " + hostContents
  }
  def Kernel() : String = {
    val kernContents = Source.fromFile("/proc/sys/kernel/osrelease").getLines.mkString
    return "Kernel:   " + kernContents
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
