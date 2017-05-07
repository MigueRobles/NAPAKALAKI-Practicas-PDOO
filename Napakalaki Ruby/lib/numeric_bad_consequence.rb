# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

require_relative "monster"
  require_relative "prize"
  require_relative "treasure_kind"

module NapakalakiGame
  class NumericBadConsequence < BadConsequence
    
    public_class_method :new
    attr_reader :nVisibleTreasures
    attr_reader :nHiddenTreasures
    
    def initialize(aText,someLevels, someVisibleTreasures, someHiddenTreasures)
      super(aText, someLevels)
      @nVisibleTreasures = someVisibleTreasures
      @nHiddenTreasures = someHiddenTreasures
    end
    
    def to_s
      mensaje = "#{super}Pierdes: #{@nVisibleTreasures} tesoros visibles y #{@nHiddenTreasures} tesoros ocultos"
    end
    
    def isEmpty
      @nVisibleTreasures == 0 && @nHiddenTreasures == 0
    end
    
    def getNVisibleTreasures
      @nVisibleTreasures
    end
    
    def getNHiddenTreasures
      @nHiddenTreasures
    end
    
    def substractHiddenTreasure(t)
      @nHiddenTreasures = [0,@nHiddenTreasures - 1].max
    end
    
    def substractVisibleTreasure(t)
      @nVisibleTreasures = [0,@nVisibleTreasures - 1].max
    end
    
    def adjustToFitTreasureLists(v,h)
      if !isEmpty
        nVisibleTreasures = [@nVisibleTreasures, v.size].min
        nHiddenTreasures = [@nHiddenTreasures, h.size].min
        
        NumericBadConsequence.new(@aText,@someLevels, nVisibleTreasures, nHiddenTreasures)
      
      else
        self
      end
    end
  end

end
