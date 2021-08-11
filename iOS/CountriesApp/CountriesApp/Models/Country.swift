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
    let region: Region
    
    enum CodingKeys: String, CodingKey {
        case code = "alpha3Code"
        case name
        case capital
        case region
    }
}

enum Region: String, Decodable, CaseIterable {
    case africa = "Africa"
    case americas = "Americas"
    case asia = "Asia"
    case europe = "Europe"
    case oceania = "Oceania"
    case polar = "Polar"
    case other = ""
}
