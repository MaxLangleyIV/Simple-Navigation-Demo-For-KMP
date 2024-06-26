package navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class SimpleNavController(initialScreen: Screen) {

    private val _currentScreen = MutableStateFlow(initialScreen)
    val currentScreen= _currentScreen.asStateFlow()

    private val backStack: MutableList<Screen> = mutableListOf()

    fun navigateTo(screen: Screen){

        backStack.add(_currentScreen.value)

        _currentScreen.update { screen }

    }

    fun navigateBack(){

        if (backStack.isNotEmpty()){

            _currentScreen.update { backStack.last() }

            backStack.removeLast()

        }

    }

}