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
            HStack() {
                Text("Name:")
                Text(country.name)
                Spacer()
            }
            .padding(.bottom)
            HStack {
                Text("Capital:")
                Text(country.capital)
                Spacer()
            }
        }
    }
}

struct CountryDetailsView_Previews: PreviewProvider {
    static var previews: some View {
        let c = Country(code: "NOR", name: "Norway", capital: "Oslo", region: .europe, flagUrl: "")
        CountryDetailsView(country: c)
    }
}
