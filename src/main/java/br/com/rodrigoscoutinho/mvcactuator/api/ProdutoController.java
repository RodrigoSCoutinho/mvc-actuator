package br.com.rodrigoscoutinho.mvcactuator.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigoscoutinho.mvcactuator.client.avaliacoes.AvaliacaoClient;
import br.com.rodrigoscoutinho.mvcactuator.client.avaliacoes.AvaliacaoModel;
import br.com.rodrigoscoutinho.mvcactuator.domain.Produto;
import br.com.rodrigoscoutinho.mvcactuator.domain.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoRepository produtos;
    private final AvaliacaoClient avaliacoes;

    public ProdutoController(ProdutoRepository produtos, AvaliacaoClient avaliacoes) {
        this.produtos = produtos;
        this.avaliacoes = avaliacoes;
    }

    @GetMapping
    public List<ProdutoModel> buscarTodos() {
        return produtos.getAll()
                .stream()
                .map(this::converterProdutoParaModelo)
                .collect(Collectors.toList());
    }

    @GetMapping("/{produtoId}")
    public ProdutoModel buscarPorId(@PathVariable Long produtoId) {
        return produtos.getOne(produtoId)
                .map(this::converterProdutoParaModeloComAvaliacao)
                .orElseThrow(RecursoNaoEncontradoException::new);
    }

    private ProdutoModel converterProdutoParaModelo(Produto produto) {
        return ProdutoModel.of(produto);
    }

    private ProdutoModel converterProdutoParaModeloComAvaliacao(Produto produto) {
        return ProdutoModel.of(produto, buscarAvaliacaoDoProduto(produto.getId()));
    }

    private List<AvaliacaoModel> buscarAvaliacaoDoProduto(Long productId) {
        return avaliacoes.buscarTodosPorProduto(productId);
    }
}
