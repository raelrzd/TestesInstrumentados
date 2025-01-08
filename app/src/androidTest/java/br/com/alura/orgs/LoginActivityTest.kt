package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import br.com.alura.orgs.ui.activity.LoginActivity
import org.junit.Test

class LoginActivityTest {

    @Test
    fun deveMostrarONomeDoAplicativoNaTelaDeLogin() {
        ActivityScenario.launch(LoginActivity::class.java)
        Espresso.onView(ViewMatchers.withText("Orgs"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}