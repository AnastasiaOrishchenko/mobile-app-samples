//
//  CountriesApi.swift
//  CountriesApp
//
//  Created by Anastasia Orishchenko on 10/08/2021.
//

import Foundation

class CountriesRestApi {
    
    func getAll(completion: @escaping ([Country]) -> ()) {
        guard let url = URL(string: "https://restcountries.eu/rest/v2/all?fields=name;capital;alpha3Code;region") else {
            print("invalid url")
            return
        }
        
        // TODO: Add error handling
        URLSession(configuration: .ephemeral).dataTask(with: url) { data, response, error in
            let countries = try! JSONDecoder().decode([Country].self, from: data!)
            DispatchQueue.main.async {
                completion(countries)
            }
        }.resume()
    }
}
