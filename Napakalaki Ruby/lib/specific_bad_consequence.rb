# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

  require_relative "monster"
  require_relative "prize"
  require_relative "treasure_kind"

class SpecificBadConsequence < BadConsequence
  public_class_method :new

  def initialize(aText, levels,someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    super(aText, levels)
    @specificVisibleTreasures = someSpecificVisibleTreasures
    @specificHiddenTreasures = someSpecificHiddenTreasures
    
  end
  
  def isEmpty
    if @specificVisibleTreasures == Array.new and @specificHiddenTreasures == Array.new
      true
    else
      false
    end
  end
  
  def
    
end
