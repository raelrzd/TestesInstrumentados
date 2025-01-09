package br.com.alura.orgs

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import br.com.alura.orgs.ui.activity.LoginActivity
import org.junit.Rule
import org.junit.Test

class LoginActivityTest {

    @get:Rule
    val rule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun deveMostrarONomeDoAplicativoNaTelaDeLogin() {
        onView(withText("Orgs")).check(matches(isDisplayed()))
    }

    @Test
    fun deveMostrarOsCamposNecessariosParaOLogin() {
        onView(withId(R.id.activity_login_usuario)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_login_senha)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_login_botao_entrar)).check(matches(isDisplayed()))
    }

}