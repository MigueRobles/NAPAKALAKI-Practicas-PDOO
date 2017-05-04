# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

  require_relative "monster"
  require_relative "prize"
  require_relative "treasure_kind"

module NapakalakiGame
  class BadConsequence
    
    @@MAXTREASURES = 10
    private_class_method :new
    attr_reader :nVisibleTreasures
    attr_reader :nHiddenTreasures
    attr_reader :specificVisibleTreasures
    attr_reader :specificHiddenTreasures


    def initialize(aText, someLevels)

      @text = aText
      @levels = someLevels
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
        " #{@text} \nDeath: #{@death}"
      else
        if (@specificHiddenTreasures == Array.new() && @specificVisibleTreasures == Array.new())
          " #{@text} \nLevels: #{@levels} \nVisibleTreasures: #{@nVisibleTreasures} \nHiddenTreasures: #{@nHiddenTreasures}"
        else
          " #{@text} \nSpecificVisibleTreasures: #{@specificVisibleTreasures} \nSpecificHiddenTreasures: #{@specificHiddenTreasures}"
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
      if !isEmpty
        if !@specificVisibleTreasures.empty?
          @specificVisibleTreasures.delete t.getType
          @nVisibleTreasures = @specificVisibleTreasures.size 
        else
          @nVisibleTreasures = [0,@nVisibleTreasures -1].max
        end
      end
    end
    
    def substractHiddenTreasure(t)
      if !isEmpty
        if !@specificHiddenTreasures.empty?
          @specificHiddenTreasures.delete t.getType
          @nHiddenTreasures = @specificHiddenTreasures.size 
        else
          @nHiddenTreasures = [0, @nHiddenTreasures -1].max
        end
      end
    end
            
   
    def adjustToFitTreasureLists(v, h)
      if !isEmpty
        nVisibleTreasures = [@nVisibleTreasures, v.size].min
        nHiddenTreasures = [@nHiddenTreasures, h.size].min
        
        visibleTypes = v.collect { |t| t.getType }
        hiddenTypes = h.collect { |t| t.getType}
        specificVisibleTreasures = Array.new
        cpySpecificVisibleTreasures = @specificVisibleTreasures.clone
        specificHiddenTreasures = Array.new
        cpySpecificHiddenTreasures = @specificHiddenTreasures.clone
        
        visibleTypes.each do |t|
          if cpySpecificVisibleTreasures.include?(t)
            specificVisibleTreasures << t
            cpySpecificVisibleTreasures.delete t
          end
        end
        hiddenTypes.each do |t|
          if cpySpecificHiddenTreasures.include?(t)
            specificHiddenTreasures << t
            cpySpecificHiddenTreasures.delete t
          end
        end
        
        if specificHiddenTreasures.empty? && specificVisibleTreasures.empty?
          BadConsequence.newLevelNumberOfTreasures @text, @levels, nVisibleTreasures, nHiddenTreasures
        else
          BadConsequence.newLevelSpecificTreasures @text, @levels, specificVisibleTreasures, specificHiddenTreasures
        end
        
      else
        self
      end
      
    end

    
  end
end