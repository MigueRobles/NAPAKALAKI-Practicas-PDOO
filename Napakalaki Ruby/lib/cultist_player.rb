# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

require_relative "player"

module NapakalakiGame

  class CultistPlayer < Player
    
    @@totalCultistPlayers = 0
    
    def initialize(p,c)
      @name = p.getName
      @level = p.getLevels
      @dead = p.isDead
      @canISteal = p.canISteal
      @hiddenTreasures = Array.new p.getHiddenTreasures
      @visibleTreasures = Array.new p.getVisibleTreasures
      @pendingBadConsequence = p.getPendingBadConsequence
      @enemy = p.getEnemy
      @myCultistCard = c
      @@totalCultistPlayers += 1


    end
    @Override
    def getCombatLevel
      (super * 1.7).truncate + @@totalCultistPlayers * @myCultistCard.getGainedLevels   
    end
    
    def getOponentLevel(m)
      m.getCombatLevelAgainstCultistPlayer      
    end
    
    def self.getTotalCultistPlayers 
      @@totalCultistPlayers
    end
    
    def shouldConvert
      false
    end
    
    def giveMeATreasure
      indice = rand(@visibleTreasures.size)
      tr = @visibleTreasures[indice]
      @visibleTreasures.delete_at(indice)
      tr
    end
    
    def canYouGiveMeATreasure
      true if (@visibleTreasures.size() > 0)
      false
    end
  end
end
