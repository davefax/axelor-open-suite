/*
 * Axelor Business Solutions
 *
 * Copyright (C) 2023 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.supplychain.service;

import java.math.BigDecimal;

public class SaleInvoicingStateServiceImpl implements SaleInvoicingStateService {
  @Override
  public int getInvoicingState(
      BigDecimal amountInvoiced, BigDecimal exTaxTotal, boolean atLeastOneInvoiceIsVentilated) {
    int invoicingState = 0;

    if (amountInvoiced.compareTo(BigDecimal.ZERO) > 0) {
      if (amountInvoiced.compareTo(exTaxTotal) < 0) {
        invoicingState = SALE_ORDER_INVOICE_PARTIALLY_INVOICED;
      }
      if (amountInvoiced.compareTo(exTaxTotal) >= 0) {
        invoicingState = SALE_ORDER_INVOICE_INVOICED;
      }
    }

    if (amountInvoiced.compareTo(BigDecimal.ZERO) == 0) {
      if (atLeastOneInvoiceIsVentilated && exTaxTotal.compareTo(BigDecimal.ZERO) == 0) {
        invoicingState = SALE_ORDER_INVOICE_INVOICED;
      } else {
        invoicingState = SALE_ORDER_INVOICE_NOT_INVOICED;
      }
    }

    return invoicingState;
  }
}
