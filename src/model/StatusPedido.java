package model;

/**
 * Enum para representar os possíveis status de um Pedido.
 * Garante que o atributo 'status' do Pedido tenha sempre um valor válido.
 */
public enum StatusPedido {
    // Definindo os estados possíveis
    RECEBIDO("Recebido"),               // Pedido aceito e aguardando processamento.
    EM_PROCESSAMENTO("Em Processamento"), // Itens sendo lavados/processados.
    PRONTO_PARA_ENTREGA("Pronto para Entrega"), // Serviço concluído.
    ENTREGUE("Entregue"),               // Pedido finalizado.
    CANCELADO("Cancelado");             // Pedido anulado.

    private final String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    // Retorna a descrição amigável para exibição (ex: no toString() ou na GUI)
    public String getDescricao() {
        return descricao;
    }

    /**
     * Helper para converter o texto lido do banco de dados de volta para o Enum.
     * @param text O nome exato (descricao) lido do banco.
     * @return O objeto StatusPedido correspondente.
     */
    public static StatusPedido fromString(String text) {
        for (StatusPedido status : StatusPedido.values()) {
            if (status.descricao.equalsIgnoreCase(text)) {
                return status;
            }
        }
        // Lançamos uma exceção se o valor no banco for inválido (erro de dado)
        throw new IllegalArgumentException("Status de pedido inválido no banco de dados: " + text);
    }
}
