

object dicegame extends App {

  import scala.io.StdIn.readLine
  import scala.util.Random

  //Initialization of required data
  class Player(val playerId : Int, var name: String, var curScore : Int, var totalScore : Int, var curPlayer: Boolean)
  var player0 = Player(0,"Player1", 0, 0, false)
  var player1 = Player(1,"Player2", 0, 0, false)
  println("The match has started")


  //to roll the die and get a number
  def rollDice(): Int = {Random.between(1, 7)}

  //to change the current player
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
    if (opt == 1) {                               //Player wants to roll the dice
      var diceNum = rollDice()
      println(s"Dice number $diceNum")
      if(diceNum == 3){                           //If the player gets unlucky number
        println("You got the unlucky number")
        player.curScore = 0
        switchPlayers()
      }else{
        player.curScore += diceNum
        println("current score " + player.curScore)
        println("Total Score " + player.totalScore)
      }
    } else if(opt == 0) {                          //Players wants to fold/ hold the current score
      player.totalScore += player.curScore
      println("Total Score " + player.totalScore)
      player.curScore = 0
      if (player.totalScore >= 10) {              //to check if any player has won
        println("      -----------   ")
        println(s"winner is ${player.name} with total score ${player.totalScore}")
        println("      -----------   ")
        return true
      }else()
      switchPlayers()
    }else{                                          // for all other inputs
      println("*******  Enterned an invalid input   ********")
    }
    return false
  }

  def startGame() : Unit = {
    var terminate = false
    player0.curPlayer = true
    while (terminate != true) {                    //if any player has won stop the match
      if (player0.curPlayer)
        terminate = gamePlay(player0)

      if(player1.curPlayer)
        terminate = gamePlay(player1)
    }
  }

  startGame()
}