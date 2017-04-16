# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada
  require_relative "prize"
  require_relative "bad_consequence"
  require_relative "treasure_kind"
  require_relative "monster"
  require "singleton"
  
module NapakalakiGame


  class Napakalaki 

    include Singleton

    private

    def initialize
      
      @currentMonster = nil
      @currentPlayer = nil
      @players = Array.new
      @dealer = nil
      @turno 
      
    end  

    def initPlayers(names)
      @@names.each do |name|         
            p = new Player(name);
            @players.add(p);
    end

    def nextPlayer
        if(@currentPlayer.getName == Array.new)
            turno = 1 + rand(@players.size)
        
        else 
            turno = (turno + 1) % players.size
        end
        currentPlayer = players.get(turno);
        
        return currentPlayer;
    end

    def nextTurnAllowed

    end

    def setEnemies

    end  

    public

    def developCombat

    end

    def discardVisibleTreasures

    end

    def discardHiddenTreasures

    end

    def makeTreasuresVisible

    end  

    def initGame(players)

    end

    def getCurrentPlayer

    end

    def getCurrentMonster

    end

    def nextTurn

    end

    def endOfGame(result)

    end
  end
end