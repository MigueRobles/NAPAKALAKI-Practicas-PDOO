# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada
  require_relative "prize"
  require_relative "player"
  require_relative "card_dealer"
  require_relative "bad_consequence"
  require_relative "treasure_kind"
  require_relative "monster"
  require "singleton"
  
  
module NapakalakiGame


  class Napakalaki 

    include Singleton

    private

    def initialize
      @currentPlayer = nil
      @players = Array.new
      @currentMonster = nil
      @dealer = CardDealer.instance

    end

    def initPlayers(names)
      
      names.each do |name|
        @players << Player.new(name)
      end

    end

    def nextPlayer
      if (@currentPlayer == nil)
        indice = rand(@players.length)
        @currentPlayer = @players[indice]
        return @players[indice]
      else
        indice = @players.index(@currentPlayer)
        if (indice == @players.size - 1)
          indice = -1
        end
        @currentPlayer = @players[indice+1]
        return @players[indice+1]
      end
    end

    def nextTurnAllowed
      if (@currentPlayer == nil)
        return true
      else  
        return @currentPlayer.validState
      end
    end

    def setEnemies
      @players.each do |player|
        indice = rand(@players.length)
        while (indice == @players.index(player))
          indice = rand(@players.length)
        end
        player.setEnemy(@players[indice])
      end 
    end  

    public

    def developCombat
      combatResult = @currentPlayer.combat(@currentMonster)
      @dealer.giveMonsterBack(@currentMonster)
      return combatResult
    end

    def discardVisibleTreasures(treasures)
      treasures.each do |treasure|
        @currentPlayer.discardVisibleTreasure(treasure)
        @dealer.giveTreasureBack(treasure)
      end
    end

    def discardHiddenTreasures (treasures)
      treasures.each do |treasure|
        @currentPlayer.discardHiddenTreasure(treasure)
        @dealer.giveTreasureBack(treasure)
      end
    end

    def makeTreasuresVisible (treasures)
      treasures.each do |treasure|
        @currentPlayer.makeTreasureVisible(treasure)
      end
    end  

    def initGame(names)
      initPlayers(names)
      setEnemies
      @dealer.initCards
      nextTurn
    end

    def getCurrentPlayer
      @currentPlayer
    end

    def getCurrentMonster
      @currentMonster
    end

    def nextTurn
      stateOK = nextTurnAllowed()
      if(stateOK)
        @currentMonster = @dealer.nextMonster
        @currentPlayer = nextPlayer
        if(@currentPlayer.isDead)
            @currentPlayer.initTreasures
        end
      else
        @currentPlayer.checkPending
      end
      return stateOK
    end

    def endOfGame(result)
      return result == CombatResult::WINGAME
    end
    
    private :initPlayers, :nextPlayer, :nextTurnAllowed, :setEnemies
  end
end