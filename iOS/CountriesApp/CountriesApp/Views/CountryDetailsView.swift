//
//  CountryDetailsView.swift
//  CountriesApp
//
//  Created by Anastasia Orishchenko on 10/08/2021.
//

import SwiftUI

struct CountryDetailsView: View {
    let country: Country
    
    var body: some View {
        
        VStack{
            LabelledText(label: "Name", text: country.name)
                .padding()
            LabelledText(label: "Capital", text: country.capital)
                .padding()
            LabelledText(label: "Region", text: country.region.rawValue)
                .padding()
        }
    }
}

struct LabelledText: View {
    
    let label: String
    let text: String
    
    var body: some View {
        HStack() {
            Text("\(label):")
            Text(text)
            Spacer()
        }
    }
}

struct CountryDetailsView_Previews: PreviewProvider {
    static var previews: some View {
        let c = Country(code: "NOR", name: "Norway", capital: "Oslo", region: .europe)
        CountryDetailsView(country: c)
    }
}
