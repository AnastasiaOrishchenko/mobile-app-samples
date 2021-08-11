//
//  TodoAppApp.swift
//  TodoApp
//
//  Created by Anastasia Orishchenko on 11/08/2021.
//

import SwiftUI

@main
struct TodoApp: App {
    var body: some Scene {
        WindowGroup {
            TodoListView(todos: TodoList())
        }
    }
}
