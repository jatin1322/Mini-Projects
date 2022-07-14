#!/usr/bin/perl

use strict;
use warnings;
#Global variables
#sample List of words you can change if you want 
my @samplewords = ("computer","radio","calculator","teacher","bureau","police","geometry","president","subject","country","enviroment","classroom","animals","province","month","politics","puzzle","instrument","kitchen","language","vampire","ghost","solution","service","software","virus","security","phonenumber","expert","website","agreement","support","compatibility","advanced","search","triathlon","immediately","encyclopedia","endurance","distance","nature","history","organization","international","championship","government","popularity","thousand","feature","wetsuit","fitness","legendary","variation","equal","approximately","segment","priority","physics","branche","science","mathematics","lightning","dispersion","accelerator","detector","terminology","design","operation","foundation","application","prediction","reference","measurement","concept","perspective","overview","position","airplane","symmetry","dimension","toxic","algebra","illustration","classic","verification","citation","unusual","resource","analysis","license","comedy","screenplay","production","release","emphasis","director","trademark","vehicle","aircraft","experiment");
#Get length of sample list in order to use rand() function

my $samplelen=@samplewords;
#Array to store secret word intialized by dashes '_'.

my @guessedword=();
#Array to store previous guesses
my @previousGuesses=();
#Varible to check Is word guessed?

my $winOrLoos=0;
#Total lives which we will reduce after every wrong move
my $total_lives=7;

#Main code starts from here.

print "Welcome to the Game\n";print "\n";
print "__________________________________________________________________________________________\n";
print "Game Rules:\n";
print "\n";
print "1)In this game there will a secret word and you have to guess the word by trying different alphabets \n";
print "2)Entered alphabet shoud be lower case letter. \n";
print "3)If the letter you guessed occurs in this secret word then it will get filled.\n";
print "4)But if it didnot occurs in word then you will loose one body part of HANGMAN \n";
print "5)If you looses all 7 body parts then you will lose this game and if you guessed word in less than 7 tries then you will won this game \n";

print "\n";
print "__________________________________________________________________________________________\n";
my $choice = 0;
#loop to run the code as many times player wants
while($choice!=1){
    #initialize the variables in every new game
 @guessedword=();
 @previousGuesses=();
 $winOrLoos=0;
 $total_lives=7;
 #selecting random word from the sample list
my $secretword=@samplewords [int((rand($samplelen)))];
 my $lengthh = length($secretword);
 print "\n";
 #initizing guessedword with _......_ 
for (my $i=0; $i < $lengthh; $i++) {
                $guessedword [$i] = '_';
 }
#Loop for asking character untill player wins or loose
while($winOrLoos!=1){
printguessedwordsofar($lengthh);
#Printing Previous Guesses
print "Previos Guesses : @previousGuesses\n";   
print "Make a guess: ";
#Taking INPUT from player
my $char = <STDIN>;
chomp $char;
my $length1 = @previousGuesses;

#checking Is the char present or not?
present($secretword,$char);

if(checkGameFineshed($secretword)){
print "Hurrah! You won this Game\n";
print "Your secret word is $secretword \n";
$winOrLoos=1;
}
else{
    if($total_lives==0){
        print "Your Hangman dies, you lost!\n";
        $winOrLoos=1;
    }
}


}


print "If you want to Play again press 1 else Press 0\n";
my $choice1 = <STDIN>;
chomp $choice1;
if($choice1==1){
    $choice = 0;
}
else{
$choice = 1;
}
}

#sub for printing secret word after every input.
sub printguessedwordsofar{
my $size=$_[0];
print "Here is your word:  ";
for (my $i=0; $i < $size; $i++) {
             print $guessedword [$i] ;
             print " ";
}
 
print "\n";


}
#sub to check if entered char is present in secret word?
sub present{
 
 
 my $sec_word=$_[0];
 my $pla_guess=$_[1];
 push(@previousGuesses, $pla_guess);
 my $letterIndex = index($sec_word, $pla_guess);



if ($letterIndex == -1) {
        print "No, secret word does not contains this letter!\n";
        
        $total_lives--;
         hangmanDisplay($total_lives);
         print "You Have $total_lives body parts left!\n";
    }
else{
 
 for (my $i=0; $i < length($sec_word); $i++) {
            my $c_at_ith_index = substr($sec_word, $i, 1);
              if ($pla_guess eq $guessedword[$i]) {
                print "You already guessed $pla_guess!\n";
                last;
            }
              if ($pla_guess eq $c_at_ith_index) {
                $guessedword [$i] = $c_at_ith_index;
            }
        }


}




}
#Sub to check if player wins by iterating on whole word.
sub checkGameFineshed {
    my ($word) = $_[0];
    my $letter;
    for (my $i=0; $i< length($word); $i++) {
        $letter = substr($word, $i, 1);
        if ($letter ne $guessedword [$i]) {
            return 0;
        }
    }
    return 1;
}
#sub for printing Hangman after each wrong move
sub hangmanDisplay() {
   my $lives=$_[0];

     
        if($lives==6)
       {print "  _______\n";
        print "  |     |\n";
        print "        |\n";
        print "        |\n";
        print "        |\n";
        print "        |\n";
        print "        |\n";
        print "  ______|\n";}

 if($lives==5)
       {print "  _______\n";
        print "  |     |\n";
        print "  O     |\n";
        print "        |\n";
        print "        |\n";
        print "        |\n";
        print "        |\n";
        print "  ______|\n";}

 if($lives==4)
       {print "  _______\n";
        print "  |     |\n";
        print "  O     |\n";
        print "  |     |\n";
        print "        |\n";
        print "        |\n";
        print "        |\n";
        print "  ______|\n";}
 if($lives==3)
       {print "  _______\n";
        print "  |     |\n";
        print "  O     |\n";
        print " \\|     |\n";
        print "        |\n";
        print "        |\n";
        print "        |\n";
        print "  ______|\n";}
 if($lives==2)
       {print "  _______\n";
        print "  |     |\n";
        print "  O     |\n";
        print " \\|/    |\n";
        print "        |\n";
        print "        |\n";
        print "        |\n";
        print "  ______|\n";}
   if($lives==1)
       {print "  _______\n";
        print "  |     |\n";
        print "  O     |\n";
        print " \\|/    |\n";
        print "  /     |\n";
        print "        |\n";
        print "        |\n";
        print "  ______|\n";}     
            
    if($lives==0)
       {print "  _______\n";
        print "  |     |\n";
        print "  X     |\n";
        print " \\|/    |\n";
        print "  /\\    |\n";
        print "        |\n";
        print "        |\n";
        print "  ______|\n";}     
                


    }
