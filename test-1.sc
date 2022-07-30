/*
remove excess code
modify the gameplay
* */

class Player(var name: String, var curScore : Int, var totalScore : Int, var curPlayer: Boolean)

import scala.io.StdIn.readLine
import scala.util.Random


var player0 = Player("Player1", 0, 0, false)
var player1 = Player("Player2", 0, 0, false)
player0.curPlayer = true
println("The match has started")

def getDice() : Int = {Random.between(1,7)}

var terminate = false
while(terminate != true){
  if(player0.curPlayer == true) {
    println("Player1 turn")
    println("Finish current match 0 or continue to roll dice 1 ")
    var opt = readLine()
    if (opt.toInt == 1) {
      player0.curScore += getDice()
      println("The current score " + player0.curScore)
      println("The total score " + player0.totalScore)
      if (player0.curScore + player0.totalScore >= 10) {
        terminate = true
        println("Player 1 is the winner")
      }
    } else {
      println("The next player can play now")
      player0.totalScore += player0.curScore
      println("The total score of player1 is " + player0.totalScore)
      player0.curScore = 0
      player0.curPlayer = false
      player1.curPlayer = true
    }
  }
  if(player1.curPlayer == true){
    println("Player2 turn")
    println("Finish current match 0 or continue to roll dice 1 ")
    var opt = readLine()
    if (opt.toInt == 1) {
      player1.curScore += getDice()
      println("The current score " + player1.curScore)
      println("The total score " + player1.totalScore)
      if (player1.curScore + player1.totalScore >= 10) {
        terminate = true
        println("Player 2 is the winner")
      }
    } else {
      println("The next player can play now")
      player1.totalScore += player1.curScore
      println("The total Score of player2 is " + player1.totalScore)
      player1.curScore = 0
      player1.curPlayer = false
      player0.curPlayer = true
    }
  }
}