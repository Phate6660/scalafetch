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
  var kernel = ""
  args.sliding(2, 2).toList.collect {
    case Array("-d", argDist: String) => distro = argDist
    case Array("-k", argKern: String) => kernel = argKern
  }
  if(distro == "true") {
    println(Functions.Distro())
  }
  if(kernel == "true") {
    println(Functions.Kernel())
  }
}
