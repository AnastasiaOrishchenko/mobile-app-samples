//
//  TodoListView.swift
//  TodoApp
//
//  Created by Anastasia Orishchenko on 11/08/2021.
//

import SwiftUI

struct TodoListView: View {
    
    @State private var addItemSheetVisible = false
    @StateObject var todos: TodoList
    
    var body: some View {
        NavigationView {
            List {
                ForEach(todos.items.indices, id: \.self) {index in
                    TodoListItem(todoItem: $todos.items[index])
                }.onDelete(perform: { indexSet in
                    todos.items.remove(atOffsets: indexSet)
                }).onMove(perform: { indices, newOffset in
                    todos.items.move(fromOffsets: indices, toOffset: newOffset)
                })
            }.toolbar(content: {
                ToolbarItem(placement: .navigationBarLeading) {
                    EditButton()
                }
                
                ToolbarItem(placement: .status) {
                    Button("Add") {
                        addItemSheetVisible = true
                    }
                    .sheet(isPresented: $addItemSheetVisible){
                        AddTodoSheet(isVisible: $addItemSheetVisible, onSave: { text in
                            todos.append(item: Todo(text: text, done: false))
                        })
                    }
                }
            }).navigationTitle("TODO")
        }
    }
}

struct TodoListItem: View {
    @Binding var todoItem: Todo
    
    var body: some View {
        HStack {
            Button(action: {
                todoItem.done.toggle()
            }) {
                todoItem.done ? Image(systemName: "checkmark.square") : Image(systemName: "square")
            }
            Text(todoItem.text)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        TodoListView(todos: TodoList())
    }
}
