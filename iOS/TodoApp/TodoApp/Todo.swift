//
//  Todo.swift
//  TodoApp
//
//  Created by Anastasia Orishchenko on 11/08/2021.
//
import SwiftUI

struct Todo: Identifiable, Hashable {
    let id: UUID = UUID()
    var text: String
    var done: Bool
}

class TodoList: ObservableObject {
    @Published var items = [Todo]()
    
    func append(item: Todo) {
        items.append(item)
    }
}
