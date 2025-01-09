package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import org.junit.Before
import org.junit.Test

class FormularioProdutoActivityTest {

    @Before
    fun preparaAmbiente() {
        AppDatabase.instancia(
            InstrumentationRegistry.getInstrumentation().targetContext
        ).clearAllTables()
    }

    @Test
    fun deveMostrarOsCamposNecessariosParaOCadastroDeProduto() {
        launch(ListaProdutosActivity::class.java)
        clicaNoFAB()

        onView(withId(R.id.activity_formulario_produto_nome)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_descricao)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_valor)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_botao_salvar)).check(matches(isDisplayed()))
    }

    @Test
    fun devePreencherOsCamposDeCadastroDeProdutosESalvar() {
        launch(ListaProdutosActivity::class.java)

        clicaNoFAB()

        preencheCamposDoProduto(
            nome = "Banana",
            descricao = "banana prata",
            valor = "6.99"
        )

        clicaNoSalvar()

        onView(withText("Banana")).check(matches(isDisplayed()))

    }

    @Test
    fun deveCadastrarUmProdutoEDepoisEditarEsteProduto() {
        launch(ListaProdutosActivity::class.java)

        clicaNoFAB()

        preencheCamposDoProduto(
            nome = "Banana nanica",
            descricao = "da horta",
            valor = "6.99"
        )

        clicaNoSalvar()

        onView(withText("Banana nanica")).perform(click())

        onView(withId(R.id.menu_detalhes_produto_editar)).perform(click())

        preencheCamposDoProduto(
            nome = "Banana prata",
            descricao = "da vendinha",
            valor = "4.99"
        )

        clicaNoSalvar()

        onView(withText("Banana prata")).check(matches(isDisplayed()))
    }

    private fun clicaNoSalvar() {
        onView(withId(R.id.activity_formulario_produto_botao_salvar)).perform(click())
    }

    private fun preencheCamposDoProduto(
        nome: String,
        descricao: String,
        valor: String
    ) {
        onView(withId(R.id.activity_formulario_produto_nome)).perform(
            replaceText(nome),
            closeSoftKeyboard()
        )
        onView(withId(R.id.activity_formulario_produto_descricao)).perform(
            replaceText(descricao),
            closeSoftKeyboard()
        )
        onView(withId(R.id.activity_formulario_produto_valor)).perform(
            replaceText(valor),
            closeSoftKeyboard()
        )
    }

    private fun clicaNoFAB() {
        onView(withId(R.id.activity_lista_produtos_fab)).perform(click())
    }

}