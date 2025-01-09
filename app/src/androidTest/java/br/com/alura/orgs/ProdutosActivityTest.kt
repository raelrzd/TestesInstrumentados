package br.com.alura.orgs

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import org.junit.Rule
import org.junit.Test

class ProdutosActivityTest {

    @get:Rule
    val rule = ActivityScenarioRule(ListaProdutosActivity::class.java)

    @Test
    fun deveMostrarONomeDoAplicativoNaTelaInicial() {
        onView(withText("Orgs")).check(matches(isDisplayed()))
    }

}