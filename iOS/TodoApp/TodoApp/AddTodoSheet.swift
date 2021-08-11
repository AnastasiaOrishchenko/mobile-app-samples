//
//  EditTodoItemView.swift
//  TodoApp
//
//  Created by Anastasia Orishchenko on 11/08/2021.
//

import SwiftUI

struct AddTodoSheet: View {
    @Binding var isVisible: Bool
    let onSave: (String) -> ()
    @State private var todoText = ""
    
    var body: some View {
        VStack{
            TextEditor(text: $todoText)
            Button(
                action: {
                    onSave(todoText)
                    isVisible = false
                },
                label: {
                    Text("Save")
                })
                .disabled(todoText.isEmpty)
        }
    }
}
