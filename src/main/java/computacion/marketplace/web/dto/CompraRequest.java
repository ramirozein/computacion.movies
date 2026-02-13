package computacion.marketplace.web.dto;

import java.util.List;

public class CompraRequest {
    private List<CompraItem> items;

    public List<CompraItem> getItems() {
        return items;
    }

    public void setItems(List<CompraItem> items) {
        this.items = items;
    }
}
