object diceG extends  App{

  import scala.io.StdIn.readLine
  import scala.util.Random
  import scala.collection.mutable.ArrayBuffer

  //array index 0 - curScore, 1 - totalScore for player 1 and 2,3 for player 2
  var players = ArrayBuffer[Int](0,0,1,0,0,0)
  //players(2) = 1
  println("The game has started")

  def rollDice(): Int = {Random.between(1,7)}

  def switchPlayers(playerId : Int) : Unit = {
    if(playerId == 0) {
      players(2) = 0
      players(5) = 1
    }else{
      players(5) = 0
      players(2) = 1
    }
  }
  def gameIntro(playerId: Int) : Unit = {
    println(" ")
    println(s"Player ${(playerId + 2) % 2}'s turn")
    println("Finish this round 0 or continue to roll dice 1")
  }
  def game(playerId : Int) : Boolean = {
    var opt = readLine()

    if(opt.toInt == 1){
      var diceNum = rollDice()
      println(s"Dice number $diceNum")
      if(diceNum == 3){
        switchPlayers(playerId)
        println("You got the unlucky number, next players turn")
        return false
      } else {
      players(0+playerId) += diceNum
      println(s"Current score ${players(0+playerId)}")
      }
    }else {
      players(1 + playerId) += players(0 + playerId)
      if (players(1 + playerId) >= 10) {
        println(" ------------ ")
        println(s"Winner is player${(playerId+1)%3} with total score")
        println(players(1 + playerId))
        return true
      }else()
      switchPlayers(playerId)
    }
    return false
  }

  def startGame() : Unit = {
    var gameEnded = false
    while (!gameEnded){
      while(!gameEnded && players(2) == 1)
        gameEnded = game(0)
      while(!gameEnded && players(5) == 1)
        gameEnded = game(3)
    }
  }

  startGame()
}