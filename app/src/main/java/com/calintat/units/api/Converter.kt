package com.calintat.units.api

import com.calintat.units.R

object Converter {

    private val item2units = mutableMapOf<Item, List<MeasurementUnit>>()

    private fun add(item: Item, init: MutableList<MeasurementUnit>.() -> Unit) {

        mutableListOf<MeasurementUnit>().apply(init).let { item2units += item to it }
    }

    private fun MutableList<MeasurementUnit>.unit(name: Int, symbol: Int, a: Double = 1.0, b: Double = 0.0, n: Double = 1.0) {

        this += MeasurementUnitImpl1(name, symbol, a, b, n)
    }

    private fun MutableList<MeasurementUnit>.unit(name: Int, symbol: Int, key: String, defValue: Float) {

        this += MeasurementUnitImpl2(name, symbol, key, defValue)
    }

    fun retrieveUnits(item: Item) = item2units[item]!!

    init {

        add(Item.LENGTH) {

            unit(R.string.metre, R.string.symbol_metre)

            unit(R.string.kilometre, R.string.symbol_kilometre, 1000.0)

            unit(R.string.mile, R.string.symbol_mile, 1609.344)

            unit(R.string.yard, R.string.symbol_yard, 0.9144)

            unit(R.string.foot, R.string.symbol_foot, 0.3048)

            unit(R.string.inch, R.string.symbol_inch, 0.0254)

            unit(R.string.centimetre, R.string.symbol_centimetre, 0.01)

            unit(R.string.millimetre, R.string.symbol_millimetre, 1e-3)

            unit(R.string.micrometre, R.string.symbol_micrometre, 1e-6)

            unit(R.string.angstrom, R.string.symbol_angstrom, 1e-10)

            unit(R.string.astronomical_unit, R.string.symbol_astronomical_unit, 149597870700.0)

            unit(R.string.light_year, R.string.symbol_light_year, 9.4607304725808e15)

            unit(R.string.parsec, R.string.symbol_parsec, 3.085677581e16)

            unit(R.string.nanometre, R.string.symbol_nanometre, 1e-9)

            unit(R.string.picometre, R.string.symbol_picometre, 1e-12)

            unit(R.string.fermi, R.string.symbol_fermi, 1e-15)

            unit(R.string.fathom, R.string.symbol_fathom, 1.8288)

            unit(R.string.furlong, R.string.symbol_furlong, 201.168)

            unit(R.string.nautical_mile, R.string.symbol_nautical_mile, 1852.0)
        }

        add(Item.AREA) {

            unit(R.string.square_metre, R.string.symbol_square_metre)

            unit(R.string.square_kilometre, R.string.symbol_square_kilometre, 1e6)

            unit(R.string.are, R.string.symbol_are, 100.0)

            unit(R.string.hectare, R.string.symbol_hectare, 10000.0)

            unit(R.string.acre, R.string.symbol_acre, 4046.8564224)

            unit(R.string.cuerda, R.string.symbol_cuerda, 3930.395625)

            unit(R.string.square_yard, R.string.symbol_square_yard, 0.83612736)

            unit(R.string.square_foot, R.string.symbol_square_foot, 9.290304e-2)

            unit(R.string.square_inch, R.string.symbol_square_inch, 6.4516e-4)
        }

        add(Item.VOLUME) {

            unit(R.string.cubic_metre, R.string.symbol_cubic_metre)

            unit(R.string.litre, R.string.symbol_litre, 0.001)

            unit(R.string.millilitre, R.string.symbol_millilitre, 1e-6)

            unit(R.string.cubic_foot, R.string.symbol_cubic_foot, 0.028316846592)

            unit(R.string.cubic_inch, R.string.symbol_cubic_inch, 16.387064e-6)

            unit(R.string.imperial_gallon, R.string.symbol_imperial_gallon, 4.54609e-3)

            unit(R.string.us_gallon, R.string.symbol_us_gallon, 3.785411784e-3)

            unit(R.string.imperial_quart, R.string.symbol_imperial_quart, 1.1365225e-3)

            unit(R.string.us_quart, R.string.symbol_us_quart, 946.352946e-6)

            unit(R.string.imperial_pint, R.string.symbol_imperial_pint, 568.26125e-6)

            unit(R.string.us_pint, R.string.symbol_us_pint, 473.176473e-6)

            unit(R.string.imperial_fluid_ounce, R.string.symbol_imperial_fluid_ounce, 28.4130625e-6)

            unit(R.string.us_fluid_ounce, R.string.symbol_us_fluid_ounce, 29.5735295625e-6)

            unit(R.string.imperial_tablespoon, R.string.symbol_imperial_tablespoon, 17.7581640625e-6)

            unit(R.string.us_tablespoon, R.string.symbol_us_tablespoon, 14.78676478125e-6)

            unit(R.string.imperial_teaspoon, R.string.symbol_imperial_teaspoon, 5.9193880208333e-6)

            unit(R.string.us_teaspoon, R.string.symbol_us_teaspoon, 4.92892159375e-6)
        }

        add(Item.MASS) {

            unit(R.string.kilogram, R.string.symbol_kilogram)

            unit(R.string.stone, R.string.symbol_stone, 6.35029318)

            unit(R.string.pound, R.string.symbol_pound, 0.45359237)

            unit(R.string.ounce, R.string.symbol_ounce, 28.349523125e-3)

            unit(R.string.imperial_ton, R.string.symbol_imperial_ton, 1016.0469088)

            unit(R.string.us_ton, R.string.symbol_us_ton, 907.18474)

            unit(R.string.tonne, R.string.symbol_tonne, 1000.0)

            unit(R.string.gram, R.string.symbol_gram, 0.001)

            unit(R.string.milligram, R.string.symbol_milligram, 1e-6)

            unit(R.string.microgram, R.string.symbol_microgram, 1e-9)

            unit(R.string.carat, R.string.symbol_carat, 0.0002)

            unit(R.string.dram, R.string.symbol_dram, 1.7718451953125e-3)

            unit(R.string.grain, R.string.symbol_grain, 64.79891e-6)

            unit(R.string.troy_pound, R.string.symbol_troy_pound, 0.3732417216)

            unit(R.string.troy_ounce, R.string.symbol_troy_ounce, 0.0311035)

            unit(R.string.pennyweight, R.string.symbol_pennyweight, 1.55517384e-3)

            unit(R.string.atomic_mass_unit, R.string.symbol_atomic_mass_unit, 1.66053892173e-27)

            unit(R.string.electron_rest_mass, R.string.symbol_electron_rest_mass, 9.1093829140e-31)
        }

        add(Item.TIME) {

            unit(R.string.millisecond, R.string.symbol_millisecond, 0.001)

            unit(R.string.second, R.string.symbol_second)

            unit(R.string.minute, R.string.symbol_minute, 60.0)

            unit(R.string.hour, R.string.symbol_hour, 3.6e3)

            unit(R.string.day, R.string.symbol_day, 86.4e3)

            unit(R.string.week, R.string.symbol_week, 604.8e3)

            unit(R.string.month, R.string.symbol_month, 2.592e6)

            unit(R.string.year, R.string.symbol_year, 31.556952e6)

            unit(R.string.decade, R.string.symbol_decade, 315.56952e6)

            unit(R.string.century, R.string.symbol_century, 3.1556952e9)
        }

        add(Item.SPEED) {

            unit(R.string.metre_per_second, R.string.symbol_metre_per_second)

            unit(R.string.mile_per_hour, R.string.symbol_mile_per_hour, 0.44704)

            unit(R.string.kilometre_per_hour, R.string.symbol_kilometre_per_hour, 0.277778)

            unit(R.string.foot_per_second, R.string.symbol_foot_per_second, 0.30480024384)

            unit(R.string.knot, R.string.symbol_knot, 0.514444855556)

            unit(R.string.speed_of_light, R.string.symbol_speed_of_light, 299792458.0)

            unit(R.string.speed_of_sound, R.string.symbol_speed_of_sound, 343.2)
        }

        add(Item.TEMPERATURE) {

            unit(R.string.kelvin, R.string.symbol_kelvin)

            unit(R.string.celsius, R.string.symbol_celsius, 1.0, 273.15)

            unit(R.string.fahrenheit, R.string.symbol_fahrenheit, 5.0 / 9, 459.67 * 5 / 9)
        }

        add(Item.CURRENCY) {

            unit(R.string.euro, R.string.symbol_euro)

            unit(R.string.us_dollar, R.string.symbol_us_dollar, "pref_currency_USD", 1.1812f)

            unit(R.string.japanese_yen, R.string.symbol_japanese_yen, "pref_currency_JPY", 130.53f)

            unit(R.string.bulgarian_lev, R.string.symbol_bulgarian_lev, "pref_currency_BGN", 1.9558f)

            unit(R.string.czech_koruna, R.string.symbol_czech_koruna, "pref_currency_CZK", 26.132f)

            unit(R.string.danish_krone, R.string.symbol_danish_krone, "pref_currency_DKK", 7.4369f)

            unit(R.string.pound_sterling, R.string.symbol_pound_sterling, "pref_currency_GBP", 0.89440f)

            unit(R.string.hungarian_forint, R.string.symbol_hungarian_forint, "pref_currency_HUF", 303.60f)

            unit(R.string.polish_zloty, R.string.symbol_polish_zloty, "pref_currency_PLN", 4.2563f)

            unit(R.string.romanian_leu, R.string.symbol_romanian_leu, "pref_currency_RON", 4.5596f)

            unit(R.string.swedish_krona, R.string.symbol_swedish_krona, "pref_currency_SEK", 9.5563f)

            unit(R.string.swiss_franc, R.string.symbol_swiss_franc, "pref_currency_CHF", 1.1414f)

            unit(R.string.norwegian_krone, R.string.symbol_norwegian_krone, "pref_currency_NOK", 9.3343f)

            unit(R.string.croatian_kuna, R.string.symbol_croatian_kuna, "pref_currency_HRK", 7.4090f)

            unit(R.string.russian_rouble, R.string.symbol_russian_rouble, "pref_currency_RUB", 71.1750f)

            unit(R.string.turkish_lira, R.string.symbol_turkish_lira, "pref_currency_TRY", 4.1602f)

            unit(R.string.australian_dollar, R.string.symbol_australian_dollar, "pref_currency_AUD", 1.4813f)

            unit(R.string.brazilian_real, R.string.symbol_brazilian_real, "pref_currency_BRL", 3.6880f)

            unit(R.string.canadian_dollar, R.string.symbol_canadian_dollar, "pref_currency_CAD", 1.4737f)

            unit(R.string.chinese_yuan_renminbi, R.string.symbol_chinese_yuan_renminbi, "pref_currency_CNY", 7.9371f)

            unit(R.string.hong_kong_dollar, R.string.symbol_hong_kong_dollar, "pref_currency_HKD", 9.2284f)

            unit(R.string.indonesian_rupiah, R.string.symbol_indonesian_rupiah, "pref_currency_IDR", 15738.31f)

            unit(R.string.israeli_shekel, R.string.symbol_israeli_shekel, "pref_currency_ILS", 4.2141f)

            unit(R.string.indian_rupee, R.string.symbol_indian_rupee, "pref_currency_INR", 75.7145f)

            unit(R.string.south_korean_won, R.string.symbol_south_korean_won, "pref_currency_KRW", 1325.50f)

            unit(R.string.mexican_peso, R.string.symbol_mexican_peso, "pref_currency_MXN", 21.0023f)

            unit(R.string.malaysian_ringgit, R.string.symbol_malaysian_ringgit, "pref_currency_MYR", 5.0620f)

            unit(R.string.new_zealand_dollar, R.string.symbol_new_zealand_dollar, "pref_currency_NZD", 1.5813f)

            unit(R.string.philippine_peso, R.string.symbol_philippine_peso, "pref_currency_PHP", 59.508f)

            unit(R.string.singapore_dollar, R.string.symbol_singapore_dollar, "pref_currency_SGD", 1.6042f)

            unit(R.string.thai_baht, R.string.symbol_thai_baht, "pref_currency_THB", 39.322f)

            unit(R.string.south_african_rand, R.string.symbol_south_african_rand, "pref_currency_ZAR", 15.6922f)
        }

        add(Item.FUEL) {

            unit(R.string.kilometre_per_litre, R.string.symbol_kilometre_per_litre)

            unit(R.string.mile_per_imperial_gallon, R.string.symbol_mile_per_imperial_gallon, 0.354006)

            unit(R.string.mile_per_us_gallon, R.string.symbol_mile_per_us_gallon, 0.425144)

            unit(R.string.litre_per_100_kilometres, R.string.symbol_litre_per_100_kilometres, 100.0, n = -1.0)

            unit(R.string.imperial_gallon_per_100_miles, R.string.symbol_imperial_gallon_per_100_miles, 35.4006, n = -1.0)

            unit(R.string.us_gallon_per_100_miles, R.string.symbol_us_gallon_per_100_miles, 42.5144, n = -1.0)
        }

        add(Item.STORAGE) {

            unit(R.string._bit, R.string.symbol_bit)

            unit(R.string._byte, R.string.symbol_byte, 8.0)

            unit(R.string.kilobit, R.string.symbol_kilobit, 1000.0)

            unit(R.string.kibibit, R.string.symbol_kibibit, 1024.0)

            unit(R.string.kilobyte, R.string.symbol_kilobyte, 8000.0)

            unit(R.string.kibibyte, R.string.symbol_kibibyte, 8192.0)

            unit(R.string.megabit, R.string.symbol_megabit, 1e6)

            unit(R.string.mebibit, R.string.symbol_mebibit, 1.048576e6)

            unit(R.string.megabyte, R.string.symbol_megabyte, 8e6)

            unit(R.string.mebibyte, R.string.symbol_mebibyte, 8.38860836)

            unit(R.string.gigabit, R.string.symbol_gigabit, 1e9)

            unit(R.string.gibibit, R.string.symbol_gibibit, 1.073741824e9)

            unit(R.string.gigabyte, R.string.symbol_gigabyte, 8e9)

            unit(R.string.gibibyte, R.string.symbol_gibibyte, 8.589934592e9)

            unit(R.string.terabit, R.string.symbol_terabit, 1e12)

            unit(R.string.tebibit, R.string.symbol_tebibit, 1.099511627776e12)

            unit(R.string.terabyte, R.string.symbol_terabyte, 8e12)

            unit(R.string.tebibyte, R.string.symbol_tebibyte, 8.796093022208e12)

            unit(R.string.petabit, R.string.symbol_petabit, 1e15)

            unit(R.string.pebibit, R.string.symbol_pebibit, 1.125899906842624e15)

            unit(R.string.petabyte, R.string.symbol_petabyte, 8e15)

            unit(R.string.pebibyte, R.string.symbol_pebibyte, 9.007199254740992e15)
        }

        add(Item.BITRATE) {

            unit(R.string.kilobit_per_second, R.string.symbol_kilobit_per_second, 1000.0)

            unit(R.string.kibibit_per_second, R.string.symbol_kibibit_per_second, 1024.0)

            unit(R.string.kilobyte_per_second, R.string.symbol_kilobyte_per_second, 8000.0)

            unit(R.string.kibibyte_per_second, R.string.symbol_kibibyte_per_second, 8192.0)

            unit(R.string.megabit_per_second, R.string.symbol_megabit_per_second, 1e6)

            unit(R.string.mebibit_per_second, R.string.symbol_mebibit_per_second, 1.048576e6)

            unit(R.string.megabyte_per_second, R.string.symbol_megabyte_per_second, 8e6)

            unit(R.string.mebibyte_per_second, R.string.symbol_mebibyte_per_second, 8.38860836)

            unit(R.string.gigabit_per_second, R.string.symbol_gigabit_per_second, 1e9)

            unit(R.string.gibibit_per_second, R.string.symbol_gibibit_per_second, 1.073741824e9)

            unit(R.string.gigabyte_per_second, R.string.symbol_gigabyte_per_second, 8e9)

            unit(R.string.gibibyte_per_second, R.string.symbol_gibibyte_per_second, 8.589934592e9)

            unit(R.string.terabit_per_second, R.string.symbol_terabit_per_second, 1e12)

            unit(R.string.tebibit_per_second, R.string.symbol_tebibit_per_second, 1.099511627776e12)

            unit(R.string.terabyte_per_second, R.string.symbol_terabyte_per_second, 8e12)

            unit(R.string.tebibyte_per_second, R.string.symbol_tebibyte_per_second, 8.796093022208e12)
        }

        add(Item.ANGLE) {

            unit(R.string.radian, R.string.symbol_radian)

            unit(R.string.degree, R.string.symbol_degree, 17.453293e-3)

            unit(R.string.arcminute, R.string.symbol_arcminute, 0.290888e-3)

            unit(R.string.arcsecond, R.string.symbol_arcsecond, 4.848137e-6)
        }

        add(Item.DENSITY) {

            unit(R.string.kilogram_per_cubic_metre, R.string.symbol_kilogram_per_cubic_metre)

            unit(R.string.kilogram_per_litre, R.string.symbol_kilogram_per_litre, 1000.0)

            unit(R.string.gram_per_cubic_centimetre, R.string.symbol_gram_per_cubic_centimetre, 1000.0)

            unit(R.string.ounce_per_cubic_foot, R.string.symbol_ounce_per_cubic_foot, 1.001153961)

            unit(R.string.ounce_per_cubic_inch, R.string.symbol_ounce_per_cubic_inch, 1.729994044e3)

            unit(R.string.pound_per_cubic_foot, R.string.symbol_pound_per_cubic_foot, 16.01846337)

            unit(R.string.pound_per_cubic_inch, R.string.symbol_pound_per_cubic_inch, 2.76799047134)

            unit(R.string.ounce_per_imperial_gallon, R.string.symbol_ounce_per_imperial_gallon, 6.236023291)

            unit(R.string.ounce_per_us_gallon, R.string.symbol_ounce_per_us_gallon, 7.489151707)

            unit(R.string.pound_per_imperial_gallon, R.string.symbol_pound_per_imperial_gallon, 99.77637266)

            unit(R.string.pound_per_us_gallon, R.string.symbol_pound_per_us_gallon, 119.8264273)
        }

        add(Item.FREQUENCY) {

            unit(R.string.hertz, R.string.symbol_hertz)

            unit(R.string.kilohertz, R.string.symbol_kilohertz, 1e3)

            unit(R.string.megahertz, R.string.symbol_megahertz, 1e6)

            unit(R.string.gigahertz, R.string.symbol_gigahertz, 1e9)

            unit(R.string.revolution_per_minute, R.string.symbol_revolution_per_minute, 0.104719755)
        }

        add(Item.FLOW) {

            unit(R.string.cubic_metre_per_second, R.string.symbol_cubic_metre_per_second)

            unit(R.string.litre_per_minute, R.string.symbol_litre_per_minute, 1.667e-5)

            unit(R.string.imperial_gallon_per_minute, R.string.symbol_imperial_gallon_per_minute, 7.577e-5)

            unit(R.string.us_gallon_per_minute, R.string.symbol_us_gallon_per_minute, 6.309e-5)

            unit(R.string.cubic_metre_per_hour, R.string.symbol_cubic_metre_per_hour, 1.0 / 3600)
        }

        add(Item.ACCELERATION) {

            unit(R.string.metre_per_second_squared, R.string.symbol_metre_per_second_squared)

            unit(R.string.galileo, R.string.symbol_galileo, 1e-2)

            unit(R.string.standard_gravity, R.string.symbol_standard_gravity, 9.80665)

            unit(R.string.mile_per_hour_per_second, R.string.symbol_mile_per_hour_per_second, 0.44704)

            unit(R.string.knot_per_second, R.string.symbol_knot_per_second, 0.514444)
        }

        add(Item.FORCE) {

            unit(R.string.newton, R.string.symbol_newton)

            unit(R.string.dyne, R.string.symbol_dyne, 1e-5)

            unit(R.string.kilopond, R.string.symbol_kilopond, 9.80665)

            unit(R.string.poundal, R.string.symbol_poundal, 0.138254954376)

            unit(R.string.pound_force, R.string.symbol_pound_force, 4.4482216152605)

            unit(R.string.ounce_force, R.string.symbol_ounce_force, 0.27801385095378125)
        }

        add(Item.PRESSURE) {

            unit(R.string.pascal, R.string.symbol_pascal)

            unit(R.string.pound_per_square_inch, R.string.symbol_pound_per_square_inch, 6.894757e3)

            unit(R.string.atmosphere, R.string.symbol_atmosphere, 101325.0)

            unit(R.string.bar, R.string.symbol_bar, 1e5)

            unit(R.string.millibar, R.string.symbol_millibar, 100.0)

            unit(R.string.millimetre_of_mercury, R.string.symbol_millimetre_of_mercury, 133.3224)

            unit(R.string.kilopascal, R.string.symbol_kilopascal, 1e3)

            unit(R.string.megapascal, R.string.symbol_megapascal, 1e6)
        }

        add(Item.TORQUE) {

            unit(R.string.foot_pound, R.string.symbol_foot_pound, 1.3558179483314004)

            unit(R.string.inch_pound, R.string.symbol_inch_pound, 0.1129848290276167)

            unit(R.string.newton_metre, R.string.symbol_newton_metre)

            unit(R.string.kilopond_metre, R.string.symbol_kilopond_metre, 9.80665)
        }

        add(Item.ENERGY) {

            unit(R.string.joule, R.string.symbol_joule)

            unit(R.string.erg, R.string.symbol_erg, 1e-7)

            unit(R.string.kilowatt_hour, R.string.symbol_kilowatt_hour, 3.6e6)

            unit(R.string.megawatt_hour, R.string.symbol_megawatt_hour, 3.6e9)

            unit(R.string.calorie, R.string.symbol_calorie, 4.1868)

            unit(R.string.kilocalorie, R.string.symbol_kilocalorie, 4.1868e3)

            unit(R.string.barrel_of_oil_equivalent, R.string.symbol_barrel_of_oil_equivalent, 6.12e9)

            unit(R.string.british_thermal_unit, R.string.symbol_british_thermal_unit, 1.05505585262e3)

            unit(R.string.electronvolt, R.string.symbol_electronvolt, 1.60217656535e-19)

            unit(R.string.imperial_gallon_atmosphere, R.string.symbol_imperial_gallon_atmosphere, 460.63256925)

            unit(R.string.us_gallon_atmosphere, R.string.symbol_us_gallon_atmosphere, 383.5568490138)
        }

        add(Item.POWER) {

            unit(R.string.watt, R.string.symbol_watt)

            unit(R.string.kilowatt, R.string.symbol_kilowatt, 1e3)

            unit(R.string.megawatt, R.string.symbol_megawatt, 1e6)

            unit(R.string.horsepower, R.string.symbol_horsepower, 735.49875)

            unit(R.string.erg_per_second, R.string.symbol_erg_per_second, 1e-7)

            unit(R.string.calorie_per_second, R.string.symbol_calorie_per_second, 4.1868)
        }
        
        add(Item.VISCOSITY) {

            unit(R.string.pascal_second, R.string.symbol_pascal_second)

            unit(R.string.poise, R.string.symbol_poise, 0.1)

            unit(R.string.pound_per_foot_hour, R.string.symbol_pound_per_foot_hour, 4.133789e-4)

            unit(R.string.pound_per_foot_second, R.string.symbol_pound_per_foot_second, 1.488164)
        }

        add(Item.CURRENT) {

            unit(R.string.ampere, R.string.symbol_ampere)

            unit(R.string.abampere, R.string.symbol_abampere, 10.0)

            unit(R.string.statampere, R.string.symbol_statampere, 3.335641e-10)
        }

        add(Item.CHARGE) {

            unit(R.string.coulomb, R.string.symbol_coulomb)

            unit(R.string.abcoulomb, R.string.symbol_abcoulomb, 10.0)

            unit(R.string.statcoulomb, R.string.symbol_statcoulomb, 3.335641e-10)

            unit(R.string.faraday, R.string.symbol_faraday, 96485.3383)

            unit(R.string.milliampere_hour, R.string.symbol_milliampere_hour, 3.6)
        }

        add(Item.VOLTAGE) {

            unit(R.string.volt, R.string.symbol_volt)

            unit(R.string.abvolt, R.string.symbol_abvolt, 1e-8)

            unit(R.string.statvolt, R.string.symbol_statvolt, 299.792458)
        }

        add(Item.LUMINANCE) {

            unit(R.string.candela_per_square_metre, R.string.symbol_candela_per_square_metre)

            unit(R.string.stilb, R.string.symbol_stilb, 1e4)

            unit(R.string.lambert, R.string.symbol_lambert, 3183.0988618)

            unit(R.string.footlambert, R.string.symbol_footlambert, 3.4262590996)
        }

        add(Item.ILLUMINANCE) {

            unit(R.string.lux, R.string.symbol_lux)

            unit(R.string.phot, R.string.symbol_phot, 1e4)

            unit(R.string.footcandle, R.string.symbol_footcandle, 10.763910417)
        }

        add(Item.RADIATION) {

            unit(R.string.gray, R.string.symbol_gray)

            unit(R.string.rad, R.string.symbol_rad, 0.01)

            unit(R.string.sievert, R.string.symbol_sievert)

            unit(R.string.rem, R.string.symbol_rem, 0.01)
        }

        add(Item.RADIOACTIVITY) {

            unit(R.string.becquerel, R.string.symbol_becquerel)

            unit(R.string.curie, R.string.symbol_curie, 3.7e10)

            unit(R.string.rutherford, R.string.symbol_rutherford, 1e6)
        }

        add(Item.GLUCOSE) {

            unit(R.string.millimole_per_litre, R.string.symbol_millimole_per_litre)

            unit(R.string.micromole_per_litre, R.string.symbol_micromole_per_litre, 1e-3)

            unit(R.string.milligram_per_decilitre, R.string.symbol_milligram_per_decilitre, 1/18.016)

            unit(R.string.milligram_per_100_millilitres, R.string.symbol_milligram_per_100_millilitres, 1/18.016)

            unit(R.string.milligram_per_cent, R.string.symbol_milligram_per_cent, 1/18.016)

            unit(R.string.milligram_per_litre, R.string.symbol_milligram_per_litre, 1/180.16)

            unit(R.string.microgram_per_millilitre, R.string.symbol_microgram_per_millilitre, 1/180.16)
        }

        add(Item.CHOLESTEROL) {

            unit(R.string.millimole_per_litre, R.string.symbol_millimole_per_litre)

            unit(R.string.micromole_per_litre, R.string.symbol_micromole_per_litre, 1e-3)

            unit(R.string.milligram_per_decilitre, R.string.symbol_milligram_per_decilitre, 1/38.665)

            unit(R.string.milligram_per_100_millilitres, R.string.symbol_milligram_per_100_millilitres, 1/38.665)

            unit(R.string.milligram_per_cent, R.string.symbol_milligram_per_cent, 1/38.665)

            unit(R.string.milligram_per_litre, R.string.symbol_milligram_per_litre, 1/386.65)

            unit(R.string.microgram_per_millilitre, R.string.symbol_microgram_per_millilitre, 1/386.65)
        }

        add(Item.CALCIUM) {

            unit(R.string.millimole_per_litre, R.string.symbol_millimole_per_litre)

            unit(R.string.micromole_per_litre, R.string.symbol_micromole_per_litre, 1e-3)

            unit(R.string.milligram_per_decilitre, R.string.symbol_milligram_per_decilitre, 1/4.0078)

            unit(R.string.milligram_per_100_millilitres, R.string.symbol_milligram_per_100_millilitres, 1/4.0078)

            unit(R.string.milligram_per_cent, R.string.symbol_milligram_per_cent, 1/4.0078)

            unit(R.string.milligram_per_litre, R.string.symbol_milligram_per_litre, 1/40.078)

            unit(R.string.microgram_per_millilitre, R.string.symbol_microgram_per_millilitre, 1/40.078)
        }

        add(Item.ELECTROLYTES) {

            unit(R.string.millimole_per_litre, R.string.symbol_millimole_per_litre)

            unit(R.string.milliequivalent_per_litre, R.string.symbol_milliequivalent_per_litre)
        }

        add(Item.FERRITIN) {

            unit(R.string.nanomole_per_litre, R.string.symbol_nanomole_per_litre)

            unit(R.string.picomole_per_litre, R.string.symbol_picomole_per_litre, 1e-3)

            unit(R.string.microgram_per_decilitre, R.string.symbol_microgram_per_decilitre, 1/44.5)

            unit(R.string.microgram_per_100_millilitres, R.string.symbol_microgram_per_100_millilitres, 1/44.5)

            unit(R.string.microgram_per_cent, R.string.symbol_microgram_per_cent, 1/44.5)

            unit(R.string.microgram_per_litre, R.string.symbol_microgram_per_litre, 1/445.0)

            unit(R.string.nanogram_per_millilitre, R.string.symbol_nanogram_per_millilitre, 1/445.0)
        }

        add(Item.HAEMOGLOBIN) {

            unit(R.string.millimole_per_litre, R.string.symbol_millimole_per_litre)

            unit(R.string.micromole_per_litre, R.string.symbol_micromole_per_litre, 1e-3)

            unit(R.string.gram_per_decilitre, R.string.symbol_gram_per_decilitre, 1/6.4458)

            unit(R.string.gram_per_100_millilitres, R.string.symbol_gram_per_100_millilitres, 1/6.4458)

            unit(R.string.gram_per_cent, R.string.symbol_gram_per_cent, 1/6.4458)

            unit(R.string.gram_per_litre, R.string.symbol_gram_per_litre, 1/64.458)

            unit(R.string.milligram_per_millilitre, R.string.symbol_milligram_per_millilitre, 1/64.458)
        }

        add(Item.CREATININE) {

            unit(R.string.millimole_per_litre, R.string.symbol_millimole_per_litre)

            unit(R.string.micromole_per_litre, R.string.symbol_micromole_per_litre, 1e-3)

            unit(R.string.milligram_per_decilitre, R.string.symbol_milligram_per_decilitre, 1/11.312)

            unit(R.string.milligram_per_100_millilitres, R.string.symbol_milligram_per_100_millilitres, 1/11.312)

            unit(R.string.milligram_per_cent, R.string.symbol_milligram_per_cent, 1/11.312)

            unit(R.string.milligram_per_litre, R.string.symbol_milligram_per_litre, 1/113.12)

            unit(R.string.microgram_per_millilitre, R.string.symbol_microgram_per_millilitre, 1/113.12)
        }

        add(Item.UREA) {

            unit(R.string.millimole_per_litre, R.string.symbol_millimole_per_litre)

            unit(R.string.micromole_per_litre, R.string.symbol_micromole_per_litre, 1e-3)

            unit(R.string.milligram_per_decilitre, R.string.symbol_milligram_per_decilitre, 1/6.006)

            unit(R.string.milligram_per_100_millilitres, R.string.symbol_milligram_per_100_millilitres, 1/6.006)

            unit(R.string.milligram_per_cent, R.string.symbol_milligram_per_cent, 1/6.006)

            unit(R.string.milligram_per_litre, R.string.symbol_milligram_per_litre, 1/60.06)

            unit(R.string.microgram_per_millilitre, R.string.symbol_microgram_per_millilitre, 1/60.06)
        }

        add(Item.ALBUMIN) {

            unit(R.string.millimole_per_litre, R.string.symbol_millimole_per_litre)

            unit(R.string.micromole_per_litre, R.string.symbol_micromole_per_litre, 1e-3)

            unit(R.string.gram_per_decilitre, R.string.symbol_gram_per_decilitre, 1/6.646)

            unit(R.string.gram_per_100_millilitres, R.string.symbol_gram_per_100_millilitres, 1/6.646)

            unit(R.string.gram_per_cent, R.string.symbol_gram_per_cent, 1/6.646)

            unit(R.string.gram_per_litre, R.string.symbol_gram_per_litre, 1/66.46)

            unit(R.string.milligram_per_millilitre, R.string.symbol_milligram_per_millilitre, 1/66.46)
        }

        add(Item.LIVER) {

            unit(R.string.nanokatal_per_litre, R.string.symbol_nanokatal_per_litre)

            unit(R.string.microkatal_per_litre, R.string.symbol_microkatal_per_litre, 1e3)

            unit(R.string.nanomole_per_second_litre, R.string.symbol_nanomole_per_second_litre)

            unit(R.string.micromole_per_second_litre, R.string.symbol_micromole_per_second_litre, 1e3)

            unit(R.string.enzyme_unit_per_litre, R.string.symbol_enzyme_unit_per_litre, 1/0.06)

            unit(R.string.international_unit_per_litre, R.string.symbol_international_unit_per_litre, 1/0.06)

            unit(R.string.micromole_per_minute_litre, R.string.symbol_micromole_per_minute_litre, 1/0.06)

            unit(R.string.micromole_per_hour_litre, R.string.symbol_micromole_per_hour_litre, 1/3.6)

            unit(R.string.micromole_per_hour_millilitre, R.string.symbol_micromole_per_hour_millilitre, 1/0.0036)
        }
    }
}