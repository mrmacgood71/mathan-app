package it.macgood.mathanapp.domain.usecase

import it.macgood.mathanapp.domain.model.Task
import it.macgood.mathanapp.domain.repository.TaskRepository
import it.macgood.mathanapp.domain.util.OrderType
import it.macgood.mathanapp.domain.util.TaskOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map


class GetTasks(
    private val repository: TaskRepository
) {
    operator fun invoke(
        taskOrder: TaskOrder = TaskOrder.QuestionNumber(OrderType.Ascending)
    ): Flow<List<Task>> {
        return repository.getTasks().map { task ->
            when(taskOrder.orderType) {
                is OrderType.Ascending -> {
                    when(taskOrder) {
                        is TaskOrder.QuestionNumber -> {
                            task.sortedBy { it.questionNumber }
                        }
                        is TaskOrder.Id -> {
                            task.sortedBy { it.id }
                        }
                    }
                }
                is OrderType.Descending -> {
                    when(taskOrder) {
                        is TaskOrder.QuestionNumber -> {
                            task.sortedByDescending { it.questionNumber }
                        }
                        is TaskOrder.Id -> {
                            task.sortedByDescending { it.id }
                        }
                    }
                }
            }
        }
    }
}