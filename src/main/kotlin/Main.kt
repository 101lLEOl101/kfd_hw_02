sealed class Method_of_travel(){

}

class Land(val type_of_road: String, val the_desired_road_condition: String) : Method_of_travel(){

}

class Water(val cant_swim: String, val unacceptable_water_weather: String) : Method_of_travel(){

}

class Air(val max_height_m: Int, val weather: String) : Method_of_travel(){

}

class Another() : Method_of_travel(){

}
abstract class Transport (protected val capacity_peoples: Int,protected val capacity_weight_kg: Int,protected val max_speed_km_h: Int){
    abstract val method_travel: Method_of_travel

    fun Get_capacity_peoples(): Int{
        return capacity_peoples
    }
    fun Get_capacity_weight(): Int{
        return capacity_weight_kg
    }
    fun Get_max_speed_km_h(): Int{
        return max_speed_km_h
    }
    private fun get_method_travel_string(method_travel: Method_of_travel) = when(method_travel) {
        is Land -> "${method_travel.type_of_road} with ${method_travel.the_desired_road_condition} condition"
        is Air -> "flight altitude: ${method_travel.max_height_m} weather: ${method_travel.weather}"
        is Water -> "cant swim in ${method_travel.cant_swim} and ${method_travel.unacceptable_water_weather}"
        is Another -> "None"
    }
    fun Get_method_travel(): String{
        return get_method_travel_string(method_travel)
    }

    fun Characteristic(): String{
        return  "capacity peoples: $capacity_peoples, capacity weight: $capacity_weight_kg, max speed: $max_speed_km_h, need way: ${Get_method_travel()}"
    }
}

class Car (capacity_peoples: Int, capacity_weight_kg: Int, max_speed_km_h: Int) : Transport(capacity_peoples, capacity_weight_kg, max_speed_km_h) {
    override val method_travel = Land("car road", "good")
    init {
        println("Car characteristic: ${Characteristic()}")
    }
}

class Plane(capacity_peoples: Int, capacity_weight_kg: Int, max_speed_km_h: Int) : Transport(capacity_peoples, capacity_weight_kg, max_speed_km_h) {
    override val method_travel = Air(11000, "not a strong thunderstorm")
    init {
        println("Plane characteristic: ${Characteristic()}")
    }
}

class Trane(capacity_peoples: Int, capacity_weight_kg: Int, max_speed_km_h: Int) : Transport(capacity_peoples, capacity_weight_kg, max_speed_km_h) {
    override val method_travel = Land("car road", "good")
    init {
        println("Trane characteristic: ${Characteristic()}")
    }
}

class Ship(capacity_peoples: Int, capacity_weight_kg: Int, max_speed_km_h: Int) : Transport(capacity_peoples, capacity_weight_kg, max_speed_km_h) {
    override val method_travel = Water("polar caps", "severe storm")
    init {
        println("Ship characteristic: ${Characteristic()}")
    }
}
fun main() {
    val ship = Ship(4, 1000, 300)
}