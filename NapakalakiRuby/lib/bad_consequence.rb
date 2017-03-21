# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

module NapakalakiGame
  class BadConsequence
    MAX_VALUE=100
    private_class_method :new

    attr_accessor :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :death, :specificHiddenTreasures, :specificVisibleTreasures

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

    def self.newDeath (aText)
      new(aText, 0, 0, 0, Array.new(), Array.new(), true)
    end

    def isEmpty
      if(@nHiddenTreasures == 0 and @nVisibleTreasures == 0 and @specificVisibleTreasures == Array.new and :specificHiddenTreasures == Array.new())
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
  end
end