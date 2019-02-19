class PageController < ApplicationController
  def index
    @sales = Sale.all
    @sum = Sale.totalSales
  end

  def import
    Sale.import(params[ :file_import ][ :file ])
    redirect_to root_url, notice: "Dados importados com sucesso!"
  end
end
