Name - Jatin
Entry Number- 2020CSB1090

1)How to Execute Program?

Type  "perl Hangman.pl" in Terminal 
Now Game will Run in terminal.


2)How to Play This Game?

First There will some game rules, Read it.
Then There will be some random word which is hidden under '_' sign, you have to guess it.


Then Dying Hangman  Will be shown to you if your guess is bad.

Game will End If Either  player wins or Hangman dies.

3)Rule Of The Game.

1)In this game there will a secret word and you have to guess the word by trying different alphabets 
2)Entered alphabet shoud be lower case letter. 
3)If the letter you guessed occurs in this secret word then it will get filled.
4)But if it didnot occurs in word then you will loose one body part of HANGMAN 
5)If you looses all 7 body parts then you will lose this game and if you guessed word in less than 7 tries then you will won this game 

4)Total SUBs created.

a)sub printguessedwordsofar
b)sub present
c)sub checkGameFineshed
d)sub hangmanDisplay()


5)How Game is working?
In this GAME i creted 2 arrays, one to store previous guesses another to store secret word behind '_' dashes.
First CPU will choose any word from the given sample list.
Then it will aks user to enter any char.
if this char is present in the secret word then cpu will fill those places it not then player will loose one body part of hangman
Now I use index funtion to check is the enterde char present in secret word?
Also if entered char already in gauessed word then it will display you have already gauessed this letter.
In hangman Display function i display hangman depending on number of lives left.

6)Step by step mechanism:

a) game starts.
b) CPU comes with secret word.
c) SHowing blanks to player.
d) Player guess char
e)If its already guessed player guesses again.
f)if letter is in secret word --> Fill it
g) If not Player will loose one body part and asked again to geauss.
h)If player guessed all character then palyer wims
i) if it ran out of lives player looses the game
j) This game ends.
PRESS 1 to play again.

-----------The-End-----------------------------------------------------------------------------------------------


