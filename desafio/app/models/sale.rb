class Sale < ApplicationRecord
  require 'csv'

  def self.import(file)
    csv = CSV.parse(File.open( file.tempfile, 'r:iso-8859-1:utf-8'), 
      :headers => true, 
      :converters => :all,
      :col_sep => "\t",
      :header_converters => lambda { |h| h.downcase.gsub(' ', '_') } )
    csv.each do |row|
      sale = Sale.new row.to_hash
      sale.save
      
    end
  end

  def self.totalSales
    return Sale.all.reduce(0) { |sum, sale| sum + (sale.purchase_count * sale.item_price) }
  end
end
