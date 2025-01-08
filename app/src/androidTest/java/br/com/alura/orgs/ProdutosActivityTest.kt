package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import org.junit.Test

class ProdutosActivityTest {

    @Test
    fun deveMostrarONomeDoAplicativoNaTelaInicial() {
        launch(ListaProdutosActivity::class.java)
        onView(withText("Orgs")).check(matches(isDisplayed()))
    }

}