require 'rails_helper'

RSpec.describe Sale, type: :model do
  
  
  describe "Retorna o total de vendas" do
    let(:sales) {[ Sale.new(purchase_count: 2, item_price: 10), Sale.new(purchase_count: 4, item_price: 20)]}

		before do
			allow(Sale).to receive(:all).and_return(sales)
    end
    
    it "returns total de vendas" do
      expect(Sale.totalSales).to eql(100.0)
    end
  end

  describe "Importing data" do
    let(:sale) { Sale.new }
    let(:data) { "purchaser name\titem description\titem price\rJoão Silva\t$10 off R$20 of food\t10"}
    
    before do
      allow(File).to receive(:open).and_return( StringIO.new(data) )
      allow(Sale).to receive(:new).and_return(sale)
    end

    it "Importa arquivo" do
      file = ActionDispatch::Http::UploadedFile.new({
        :filename => 'test_photo_1.jpg',
        :type => 'image/jpeg',
        :tempfile => File.new("#{Rails.root}/spec/file/example_input.tab")
      })
      expect(sale).to receive(:save).once
      Sale.import(file)
    end
  end

end
