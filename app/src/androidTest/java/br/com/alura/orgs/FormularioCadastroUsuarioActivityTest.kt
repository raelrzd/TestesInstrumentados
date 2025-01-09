package br.com.alura.orgs

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.ui.activity.FormularioCadastroUsuarioActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FormularioCadastroUsuarioActivityTest {

    @get:Rule
    val rule = ActivityScenarioRule(FormularioCadastroUsuarioActivity::class.java)

    @Before
    fun preparaAmbiente() {
        AppDatabase.instancia(
            InstrumentationRegistry.getInstrumentation().targetContext
        ).clearAllTables()
    }

    @Test
    fun deveMostrarOsCamposNecessariosParaOCadastroDeUsuario() {
        onView(withId(R.id.activity_formulario_cadastro_usuario)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_cadastro_email)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_cadastro_senha)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_cadastro_botao_cadastrar)).check(matches(isDisplayed()))
    }

    @Test
    fun devePreencherOsCamposDeCadastroDeUsuarioESalvar() {
        onView(withId(R.id.activity_formulario_cadastro_usuario)).perform(
            typeText("usuario"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.activity_formulario_cadastro_email)).perform(
            typeText("usuario@teste.com"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.activity_formulario_cadastro_senha)).perform(
            typeText("teste123"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.activity_formulario_cadastro_botao_cadastrar)).perform(click())
    }

}