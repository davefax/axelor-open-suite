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
package com.axelor.apps.account.service.moveline;

import com.axelor.apps.account.db.Account;
import com.axelor.apps.account.db.Move;
import com.axelor.apps.account.db.MoveLine;
import com.axelor.apps.account.db.Reconcile;
import com.axelor.exception.AxelorException;

public interface MoveLineTaxService {

  void autoTaxLineGenerate(Move move, Account account) throws AxelorException;

  MoveLine computeTaxAmount(MoveLine moveLine) throws AxelorException;

  MoveLine reverseTaxPaymentMoveLines(MoveLine customerMoveLine, Reconcile reconcile)
      throws AxelorException;

  MoveLine generateTaxPaymentMoveLineList(
      MoveLine customerPaymentMoveLine, MoveLine invoiceMoveLine, Reconcile reconcile)
      throws AxelorException;

  int getVatSystem(Move move, MoveLine moveline) throws AxelorException;

  void checkTaxMoveLines(Move move) throws AxelorException;
}
