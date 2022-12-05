package it.macgood.mathanapp.ui.guidebook.tasks.task

import it.macgood.mathanapp.domain.model.Task
import it.macgood.mathanapp.domain.util.OrderType
import it.macgood.mathanapp.domain.util.TaskOrder

data class TaskState (
    val notes: List<Task> = emptyList(),
    val noteOrder: TaskOrder = TaskOrder.QuestionNumber(OrderType.Ascending),
    val isOrderSectionVisible: Boolean = false
) {

}