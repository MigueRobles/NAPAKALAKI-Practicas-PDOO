# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada
module NapakalakiGame

  class CultistPlayer < Player
    
    @totalCultistPlayers = 0
    
    def initialize(p,c)
      @name = p.getName
      @level = p.getLevels
      @dead = p.isDead
      @canISteal = p.CanI
      @hiddenTreasures = Array.new p.getHT
      @visibleTreasures = Array.new p.getVT
      @pendingBadConsequence = p.getPendingBadConsequence
      @enemy = p.getEnemy
      @myCultistCard = c

    end
    
    def getCombatLevel
      super.getCombatLevel*1.7 + @myCultistCard.getGainedLevels + @totalCultistPlayers      
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
