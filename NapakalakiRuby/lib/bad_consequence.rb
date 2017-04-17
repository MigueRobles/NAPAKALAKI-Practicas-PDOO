# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

  require_relative "monster"
  require_relative "prize"
  require_relative "treasure_kind"

module NapakalakiGame
  class BadConsequence
    
    @@MAXTREASURES = 10
    private_class_method :new


    def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures,someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)

      @text = aText
      @levels = someLevels
      @nVisibleTreasures = someVisibleTreasures
      @nHiddenTreasures = someHiddenTreasures
      @death = death
      @specificVisibleTreasures = someSpecificVisibleTreasures
      @specificHiddenTreasures = someSpecificHiddenTreasures
    end 


  def self.newLevelNumberOfTreasures (aText, someLevels, someVisibleTreasures, someHiddenTreasures)
      new(aText, someLevels, someVisibleTreasures, someHiddenTreasures, Array.new(), Array.new(), false)
    end

    def self.newLevelSpecificTreasures (aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
      new(aText, someLevels, 0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures, false)
    end

    def self.newDeath (aText, death)
      new(aText, Player.MAXLEVEL, @@MAXTREASURES, @@MAXTREASURES, Array.new(), Array.new(), death)
    end

    def isEmpty
      if(@nHiddenTreasures == 0 and @nVisibleTreasures == 0 and @specificVisibleTreasures == Array.new and @specificHiddenTreasures == Array.new())
        true
      else
        false
      end
      
    end
    
    def getLevels
      @levels      
    end
    
    def to_s
      if (@death == true)
        "Text: #{@text} \nDeath: #{@death}"
      else
        if (@specificHiddenTreasures == Array.new() && @specificVisibleTreasures == Array.new())
          "Text: #{@text} \nLevels: #{@levels} \nVisibleTreasures: #{@nVisibleTreasures} \nHiddenTreasures: #{@nHiddenTreasures}"
        else
          "Text: #{@text} \nSpecificVisibleTreasures: #{@specificVisibleTreasures} \nSpecificHiddenTreasures: #{@specificHiddenTreasures}"
        end
      end
    end
    
    def getNVisibleTreasures
      @nVisibleTreasures
    end
    
    def getNHiddenTreasures
      @nHiddenTreasures
    end
    
    def getSpecificVisibleTreasures
      @specificVisibleTreasures
    end
    
    def getSpecificHiddenTreasures
      @specificHiddenTreasures
    end
    
    def getDeath
      @death
    end

    def substractVisibleTreasure(t)
      @specificVisibleTreasures.delete_at(@specificVisibleTreasures.index(t.getType())) if (@specificVisibleTreasures.include?(t.getType))
    end
    
    def substractHiddenTreasure(t)
      @specificHiddenTreasures.delete_at(@specificHiddenTreasures.index(t.getType())) if (@specificHiddenTreasures.include?(t.getType))
     
    end        
   
        def adjustToFitTreasureLists (v,h) 
      
      if (@death == true)
        return BadConsequence.newDeath(@text, true)
      end
      
      if (@nHiddenTreasures == 0 && @nVisibleTreasures == 0)
        return BadConsequence.newLevelNumberOfTreasures(@text, @levels, @nVisibleTreasures, @nHiddenTreasures)
      else
         visibleKind = Array.new
        hiddenKind = Array.new
        visibleToLose = Array.new
        hiddenToLose = Array.new

        v.each do |treasure|
          visibleKind << treasure.getType
        end

        h.each do |treasure|
          hiddenKind << treasure.getType
        end

        @specificVisibleTreasures.each do |kind|
          if (visibleToLose.count(kind) < visibleKind.count(kind))
            visibleToLose << kind
          end
        end

        @specificHiddenTreasures.each do |kind|
          if (hiddenToLose.count(kind) < hiddenKind.count(kind))
            hiddenToLose << kind
          end
        end

        return BadConsequence.newLevelSpecificTreasures(@text, @levels, visibleToLose, hiddenToLose)
      end
      
    end

    
  end
end