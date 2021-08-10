//
//  CountryListView.swift
//  CountriesApp
//
//  Created by Anastasia Orishchenko on 10/08/2021.
//

import SwiftUI

struct CountryListView: View {
    
    @State var countries : [Country]?
    
    var body: some View {
        NavigationView {
            // TODO: Find another way of appending common modifiers
            VStack {
                if let countries = countries {
                    List{
                        ForEach(countries, id: \.code , content: { country in
                            CountryListItem(country: country)
                        })
                    }
                } else {
                    ProgressView()
                }}.navigationTitle("Countries")
                .onAppear() {
                    CountriesRestApi().getAll {
                        countries in self.countries = countries
                    }
                }
        }
    }
}

struct CountryListItem: View {
    let country: Country
    
    var body: some View {
        NavigationLink(destination: CountryDetailsView(country: country)) {
            Text(country.name)
        }
    }
}
