# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

  require_relative "monster"
  require_relative "prize"
  require_relative "treasure_kind"

  module NapakalakiGame
  class SpecificBadConsequence < BadConsequence
    public_class_method :new

    def initialize(aText, levels,someSpecificVisibleTreasures, someSpecificHiddenTreasures)
      super(aText, levels)
      @specificVisibleTreasures = someSpecificVisibleTreasures
      @specificHiddenTreasures = someSpecificHiddenTreasures

    end

    def to_s
      "#{super}\nSpecificVisibleTreasures: #{@specificVisibleTreasures} \nSpecificHiddenTreasures: #{@specificHiddenTreasures}"
    end

    def isEmpty
      if @specificVisibleTreasures == Array.new and @specificHiddenTreasures == Array.new
        true
      else
        false
      end
    end

    def substractVisibleTreasure(t)
      if !@specificVisibleTreasures.empty?
        @specificVisibleTreasures.delete t.getType
      end
    end

      def substractHiddenTreasure(t)
        if !@specificHiddenTreasures.empty?
          @specificHiddenTreasures.delete t.getType
        end      
      end

    def getSpecificVisibleTreasures
      @specificVisibleTreasures
    end

    def getSpecificHiddenTreasures
      @specificHiddenTreasures
    end



    def adjustToFitTreasureLists(v,h)

      if !isEmpty
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
        SpecificBadConsequence.new @text, @levels, specificVisibleTreasures, specificHiddenTreasures
      end
    end  
  end
end 