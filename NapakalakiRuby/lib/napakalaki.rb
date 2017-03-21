# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada
require_relative "prize"
require_relative "bad_consequence"
require_relative "treasure_kind"
require_relative "monster"
require "singleton"
  
class Napakalaki 
   
  include Singleton
  
  private
  
  def initialize

  end  
  
  def initPlayers(names)
    
  end
  
  def nextPlayer
    
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
