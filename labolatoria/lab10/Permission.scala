trait Low
trait High extends Low
trait Super extends High

trait User[+ReadAuthorizationLevel <: Low, +WriteAuthorizationLevel <: Low]:
  def secret: String
  def secret(s: String): Unit

class CUser[+ReadLevel <: Low, +WriteLevel <: Low](private var secretString: String) extends User[ReadLevel, WriteLevel] :
  def secret: String = secretString
  def secret(s: String): Unit = secretString = s

class Terminal[ReadAuthorizationLevel <: Low, WriteAuthorizationLevel <: ReadAuthorizationLevel](private var secretString: String):
  def read(user: User[ReadAuthorizationLevel, _]): Unit = user.secret(secretString)
  def write(user: User[_, WriteAuthorizationLevel]): Unit = secretString = user.secret

@main
def main(): Unit =
  val LLTerminal = Terminal[Low, Low]("Low Low")
  val LHTerminal = Terminal[Low, High]("Low High")
  val LSTerminal = Terminal[Low, Super]("Low Super")
  val HHTerminal = Terminal[High, High]("High High")
  val HSTerminal = Terminal[High, Super]("High Super")
  val SSTerminal = Terminal[Super, Super]("Super Super")
  //val HLTerminal = Terminal[High, Low]("High Low")

  val lluser = LLUser("low - read, low - write")
  val hluser = HLUser("high - read, low - write")
  val sluser = SLUser("super - read, low - write")
  val hhuser = HHUser("high - read, high - write")
  val shuser = SHUser("super - read, high - write")
  val ssuser = SSUser("super - read, super - write")

  LLTerminal.write(lluser)
  LLTerminal.write(hluser)
  LLTerminal.write(sluser)
  LLTerminal.write(hhuser)
  LLTerminal.write(shuser)
  LLTerminal.write(ssuser)

  //HHTerminal.write(hluser)
  //HHTerminal.write(lluser)
  //HHTerminal.write(sluser)
  HHTerminal.write(hhuser)
  HHTerminal.write(shuser)
  HHTerminal.write(ssuser)

  //SSTerminal.write(hluser)
  //SSTerminal.write(lluser)
  //SSTerminal.write(sluser)
  //SSTerminal.write(lhuser)
  //SSTerminal.write(hhuser)
  //SSTerminal.write(shuser)
  SSTerminal.write(ssuser)


  LLTerminal.read(lluser)
  LLTerminal.read(hluser)
  LLTerminal.read(sluser)
  LLTerminal.read(hhuser)
  LLTerminal.read(shuser)
  LLTerminal.read(ssuser)

  //HHTerminal.read(lluser)
  //HHTerminal.read(lhuser)
  //HHTerminal.read(lsuser)
  HHTerminal.read(hluser)
  HHTerminal.read(sluser)
  HHTerminal.read(hhuser)
  HHTerminal.read(shuser)
  HHTerminal.read(ssuser)

  //SSTerminal.read(lluser)
  //SSTerminal.read(lhuser)
  //SSTerminal.read(lsuser)
  //SSTerminal.read(hluser)
  //SSTerminal.read(sluser)
  //SSTerminal.read(hhuser)
  SSTerminal.read(shuser)
  SSTerminal.read(ssuser)

  println(ssuser.secret)
  println(shuser.secret)
  println(hhuser.secret)








