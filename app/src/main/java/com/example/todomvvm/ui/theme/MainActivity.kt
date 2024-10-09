package com.example.todomvvm.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todomvvm.model.TodoJ
import com.example.todomvvm.viewmodel.TodoViewModel
import com.example.todomvvm.ui.theme.TodoMVVMTheme

class MainActivity : ComponentActivity() {
    private val todoViewModel: TodoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoScreen(todoViewModel)
        }
    }
}

@Composable
fun TodoScreen(todoViewModel: TodoViewModel) {
    val todos = todoViewModel.todos.collectAsState().value
    TodoList(todos)
}

@Composable
fun TodoList(todos: List<TodoJ>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(todos) { todo ->
            Text(
                text = todo.title,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoMVVMTheme {
        TodoScreen(TodoViewModel())
    }
}
