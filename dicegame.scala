

object dicegame extends App {

  import scala.io.StdIn.readLine
  import scala.util.Random

  class Player(val playerId : Int, var name: String, var curScore : Int, var totalScore : Int, var curPlayer: Boolean)

  var player0 = Player(0,"Player1", 0, 0, false)
  var player1 = Player(1,"Player2", 0, 0, false)
  println("The match has started")


  def rollDice(): Int = {Random.between(1, 7)}

  def switchPlayers() : Unit = {
    println(" xxxxxxx    Next players turn    xxxxxxx")
    player0.curPlayer ^= true
    player1.curPlayer ^= true
  }

  def gamePlay(player: Player):Boolean = {
    println(" ")
    println(s"${player.name} turn")
    println("Finish current match 0 or continue to roll dice 1 ")

    var opt = readLine().toInt
    if (opt == 1) {
      var diceNum = rollDice()
      println(s"Dice number $diceNum")
      if(diceNum == 3){
        println("You got the unlucky number")
        player.curScore = 0
        switchPlayers()
      }else{
        player.curScore += diceNum
        println("current score " + player.curScore)
        println("Total Score " + player.totalScore)
      }
    } else if(opt == 0) {
      player.totalScore += player.curScore
      println("Total Score " + player.totalScore)
      player.curScore = 0
      if (player.totalScore >= 10) {
        println("      -----------   ")
        println(s"winner is ${player.name} with total score ${player.totalScore}")
        println("      -----------   ")
        return true
      }else()
      switchPlayers()
    }else{
      println("*******  Enterned an invalid input   ********")
    }
    return false
  }

  def startGame() : Unit = {
    var terminate = false
    player0.curPlayer = true
    while (terminate != true) {
      if (player0.curPlayer)
        terminate = gamePlay(player0)

      if(player1.curPlayer)
        terminate = gamePlay(player1)
    }
  }

  startGame()
}