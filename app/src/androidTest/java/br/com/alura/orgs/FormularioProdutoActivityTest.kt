package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import br.com.alura.orgs.ui.activity.FormularioProdutoActivity
import org.junit.Test

class FormularioProdutoActivityTest {

    @Test
    fun deveMostrarOsCamposNecessariosParaOCadastroDeProduto() {
        ActivityScenario.launch(FormularioProdutoActivity::class.java)
        Espresso.onView(ViewMatchers.withId(R.id.activity_formulario_produto_nome))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.activity_formulario_produto_descricao))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.activity_formulario_produto_valor))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.activity_formulario_produto_botao_salvar))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}