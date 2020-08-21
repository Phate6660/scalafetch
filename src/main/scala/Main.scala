import scala.io.Source

object Functions {
  def Distro() : String = {
    val distContents = Source.fromFile("/etc/os-release").getLines.take(1).next().split("=") 
    return "Distro: " + distContents(1)
  }
  def Kernel() : String = {
    val kernContents = Source.fromFile("/proc/sys/kernel/osrelease").getLines.mkString
    return "Kernel: " + kernContents
  }
}

object Main extends App {
  var distro = ""
  var help = ""
  var kernel = ""
  args.sliding(2, 2).toList.collect {
    case Array("-d", argDist: String) => distro = argDist
    case Array("-h", argHelp: String) => help = argHelp
    case Array("-k", argKern: String) => kernel = argKern
  }
  if(help == "true") {
    println("""-d  display the distro
-h  display this help
-k  display the kernel""")
    System.exit(0)
  }
  if(distro == "true") {
    println(Functions.Distro())
  }
  if(kernel == "true") {
    println(Functions.Kernel())
  }
}
