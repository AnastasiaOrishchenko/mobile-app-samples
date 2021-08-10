//
//  Country.swift
//  CountriesApp
//
//  Created by Anastasia Orishchenko on 10/08/2021.
//

import Foundation

struct Country: Decodable {
    let code: String
    let name: String
    let capital: String
    let region: Region?
    let flagUrl: String
    
    enum CodingKeys: String, CodingKey {
        case code = "alpha3Code"
        case name
        case capital
        case region
        case flagUrl = "flag"
    }
}

enum Region: String, Decodable {
    case africa = "Africa"
    case americas = "Americas"
    case asia = "Asia"
    case europe = "Europe"
    case oceania = "Oceania"
    case polar = "Polar"
    case other = ""
}
